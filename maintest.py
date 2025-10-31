import streamlit as st
import datetime
import io
from fpdf import FPDF
from traveltest import TravelPlanner

# ----------------------------------------
# Page Configuration & Styling
# ----------------------------------------
st.set_page_config(
    page_title="Travel Planner",
    page_icon="✈️",
    layout="wide",
    initial_sidebar_state="expanded"
)

st.markdown("""
<style>
    /* Main padding */
    .main { padding: 2rem; }
    .block-container { padding-top: 2rem; padding-bottom: 2rem; }

    /* Headers */
    h1 { color: #2B6CB0; }         /* Dark blue */
    h2, h3 { color: #2C5282; }     /* Slightly lighter blue */

    /* Agent cards */
    .agent-card {
        background-color: #EBF8FF;  /* Light blue background */
        border-radius: 12px;
        padding: 20px;
        margin-bottom: 20px;
        border-left: 6px solid #3182CE;  /* Blue border */
        color: #1A202C;                   /* Dark text */
    }

    /* Summary card */
    .summary-card {
        background-color: #F0FFF4;  /* Soft green background */
        border-radius: 12px;
        padding: 20px;
        margin-bottom: 20px;
        border-left: 6px solid #38A169;  /* Green border */
        color: #1A202C;                   /* Dark text */
    }

    /* Links inside cards */
    .agent-card a, .summary-card a { color: #2B6CB0; text-decoration: none; }
    .agent-card a:hover, .summary-card a:hover { text-decoration: underline; }

    /* Sidebar header */
    .sidebar .sidebar-content h2 { color: #2C5282; }

</style>
""", unsafe_allow_html=True)


# ----------------------------------------
# Header
# ----------------------------------------
def render_header():
    st.title("Travel Itinerary Planner and Optimizer")
    st.markdown("Let our AI agents help you plan your perfect trip!")

# ----------------------------------------
# Sidebar Configuration
# ----------------------------------------
def render_sidebar():
    """Render sidebar with model selection and instructions"""
    with st.sidebar:
        st.header("Configuration")
        model_choice = st.radio(
            "Select AI Model",
            options=["gpt-3.5-turbo", "gpt-4o"],
            index=0
        )

        model_map = {
            "gpt-3.5-turbo": "openai",
            "gpt-4o": "openai"
        }

        st.markdown("---")
        st.markdown("### How it works")
        st.markdown("""
        This app uses multiple AI agents to plan your trip:
        1. **Flight Finder** searches for flights  
        2. **Hotel Explorer** finds accommodations  
        3. **Attraction Scout** discovers points of interest  
        4. **Trip Summarizer** builds your itinerary
        """)
        return model_map[model_choice]

# ----------------------------------------
# Trip Details Form
# ----------------------------------------
def render_trip_form():
    """Render the form for trip details input"""
    with st.form("trip_details_form"):
        st.header("Enter Your Trip Details")
        col1, col2 = st.columns(2)

        # --- Origin and Destination ---
        with col1:
            origin = st.text_input("Source", "New York")
            destination = st.text_input("Destination", "Tokyo")

        # --- Departure & Return Dates ---
        with col2:
            today = datetime.date.today()
            start_date = st.date_input(
                "Departure Date",
                value=today + datetime.timedelta(days=30),
                min_value=today
            )
            end_date = st.date_input(
                "Return Date",
                value=today + datetime.timedelta(days=37),
                min_value=start_date
            )

        trip_length = (end_date - start_date).days
        if trip_length < 0:
            st.error("Return date cannot be before departure date.")
        else:
            st.write(f"Trip Duration: {trip_length} days")

        # --- Budget & Travelers ---
        col1, col2 = st.columns(2)
        with col1:
            budget = st.selectbox("Budget Level", options=["Budget", "Moderate", "Luxury"], index=1)
        with col2:
            travelers = st.number_input("Number of Travelers", min_value=1, max_value=10, value=2)

        # --- Interests ---
        interests = st.multiselect(
            "Interests",
            options=[
                "History & Culture", "Nature & Outdoors", "Food & Cuisine",
                "Shopping", "Art & Museums", "Relaxation", "Adventure"
            ],
            default=["History & Culture", "Food & Cuisine"]
        )

        submitted = st.form_submit_button("Plan My Trip")

        if submitted:
            if end_date < start_date:
                st.error("Return date must be after departure date.")
                return {'submitted': False}

            return {
                'origin': origin,
                'destination': destination,
                'start_date': start_date,
                'end_date': end_date,
                'budget': budget,
                'travelers': travelers,
                'interests': interests,
                'submitted': True
            }

        return {'submitted': False}

# ----------------------------------------
# Agent Display Cards
# ----------------------------------------
def display_agent_card(title, result, error, card_class="agent-card"):
    """Reusable display for Flights, Hotels, Attractions"""
    st.markdown(f"<div class='{card_class}'><h3>{title}</h3>", unsafe_allow_html=True)
    if error:
        st.error(f"Error: {error}")
    else:
        st.markdown(result)
    st.markdown("</div>", unsafe_allow_html=True)

# ----------------------------------------
# Example Content Before Submission
# ----------------------------------------
def display_example_content():
    st.info("Fill in your trip details and click 'Plan My Trip' to get started!")

    st.markdown("### Sample Trip Plan")
    col1, col2, col3 = st.columns(3)

    with col1:
        st.markdown("#### Flight Options")
        st.markdown(
            "- Multiple airlines with various departure times\n"
            "- Direct and connecting flight options\n"
            "- Price ranges for economy and business class"
        )

    with col2:
        st.markdown("#### Hotel Recommendations")
        st.markdown(
            "- Options for your chosen budget level\n"
            "- Best neighborhoods to stay in\n"
            "- Amenities and nearby attractions"
        )

    with col3:
        st.markdown("#### Must-See Attractions")
        st.markdown(
            "- Top-rated sights and experiences\n"
            "- Hidden gems and local favorites\n"
            "- Activities matched to your interests"
        )

# ----------------------------------------
# Markdown to PDF Converter
# ----------------------------------------
def markdown_to_pdf(markdown_text: str) -> bytes:
    pdf = FPDF()
    pdf.add_page()
    pdf.set_auto_page_break(auto=True, margin=15)
    pdf.set_font("Arial", size=12)

    for line in markdown_text.split("\n"):
        line = line.strip()
        safe_line = line.replace("•", "-").encode("latin-1", "replace").decode("latin-1")

        if safe_line.startswith("# "):
            pdf.set_font("Arial", "B", size=16)
            pdf.cell(0, 10, safe_line[2:], ln=True)
            pdf.set_font("Arial", size=12)
        elif safe_line.startswith("## "):
            pdf.set_font("Arial", "B", size=14)
            pdf.cell(0, 10, safe_line[3:], ln=True)
            pdf.set_font("Arial", size=12)
        elif safe_line.startswith("- "):
            pdf.multi_cell(0, 8, f"- {safe_line[2:]}")
        else:
            pdf.multi_cell(0, 8, safe_line)
        pdf.ln(2)

    pdf_bytes = pdf.output(dest='S').encode('latin-1')
    return pdf_bytes

# ----------------------------------------
# Process Trip Planning
# ----------------------------------------
def process_trip_planning(model_type, trip_details):
    try:
        planner = TravelPlanner(model_type)
        progress_container = st.empty()
        progress_container.info("Planning your trip... Please wait...")

        results = planner.generate_trip_plan(trip_details)
        progress_container.empty()

        st.header("Your Trip Plan")
        tabs = st.tabs(["Flights", "Hotels", "Attractions", "Complete Plan"])

        with tabs[0]:
            display_agent_card("🛫 Flight Finder", results['flight_result'], results['errors']['flight_error'])
        with tabs[1]:
            display_agent_card("🏨 Hotel Explorer", results['hotel_result'], results['errors']['hotel_error'])
        with tabs[2]:
            display_agent_card("🏛️ Attraction Scout", results['attraction_result'], results['errors']['attraction_error'])
        with tabs[3]:
            display_agent_card("📝 Trip Summarizer", results['summary_result'], results['errors']['summary_error'], card_class="summary-card")

        pdf_bytes = markdown_to_pdf(results['trip_plan_text'])
        st.download_button(
            label="📄 Download Trip Plan (PDF)",
            data=pdf_bytes,
            file_name=f"trip_plan_{trip_details['destination']}_{trip_details['start_date'].strftime('%Y-%m-%d')}.pdf",
            mime="application/pdf"
        )

    except Exception as e:
        st.error(f"An error occurred: {str(e)}")

# ----------------------------------------
# Main App
# ----------------------------------------
def main():
    render_header()
    model_type = render_sidebar()
    trip_details = render_trip_form()

    if trip_details['submitted']:
        process_trip_planning(model_type, trip_details)
    else:
        display_example_content()

if __name__ == "__main__":
    main()

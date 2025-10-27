function loadContent(page) {
  let content = '';

  if (page.toLowerCase() === 'home') {
    content = `
      <div class="flex flex-column align-content-center justify-center">
        <h1 class="font-segoe-ui text-xl text-orange text-center">Welcome to Empowering the Nation</h1>

        <p class="font-segoe-ui text-md text-orange text-center">Founded in 2022 by Precious Radebe, Empowering the Nation is a<br/>
          proudly South African initiative dedicated to uplifting domestic workers<br/>
          and gardeners through practical, culturally relevant training.
        </p>
        
        <p class="font-segoe-ui text-m text-orange text-center">Our programmes blend traditional wisdom with modern skills, creating opportunities<br/>
          for sustainable employment and personal growth. Whether you're looking for a<br/>
          six-month Learnership or a Short Skills Training Programme, we are here to guide you<br/>every step of the way.
        </p>
      </div>
    `;
  } 
  
  else if (page.toLowerCase() === 'about') {
    content = `
      <div class="container">
        <div class="about-content">
          <p class="about-text">
            Founded in 2022 by Precious Radebe, Empowering the Nation is a proudly South African initiative dedicated to uplifting domestic workers and gardeners through practical, culturally relevant training.
          </p>
          
          <p class="about-text">
            Our programmes blend traditional wisdom with modern skills, creating opportunities for sustainable employment and personal growth. Whether you're looking for a six-month Learnership or a Short Skills Training Programme, we are here to guide you every step of the way.
          </p>
          
          <p class="about-text">
            We believe in the power of community and the dignity of work. By equipping individuals with valuable life and work skills, we help unlock doors to brighter futures for families and communities.
          </p>
          
          <p class="about-text">
            Together with our partners and supporters, we strive to foster resilience, confidence, and lasting change in the lives of those we serve. Our vision is a nation where every worker is empowered, respected, and given opportunities to thrive.
          </p>
        </div>

        <div class="carousel-container">
          <button class="carousel-btn prev-btn" onclick="moveCarousel(-1)">
            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <polyline points="15 18 9 12 15 6"></polyline>
            </svg>
          </button>
          
          <div class="carousel-wrapper">
            <div class="carousel-track" id="aboutCarouselTrack">
              <div class="carousel-slide">
                <img src="assets/images/about1.png" alt="Community training">
              </div>
              <div class="carousel-slide">
                <img src="assets/images/about2.png" alt="Skills development">
              </div>
              <div class="carousel-slide">
                <img src="assets/images/about3.png" alt="Practical training">
              </div>
              <div class="carousel-slide">
                <img src="assets/images/about4.png" alt="Empowered workers">
              </div>
            </div>
          </div>
          
          <button class="carousel-btn next-btn" onclick="moveCarousel(1)">
            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <polyline points="9 18 15 12 9 6"></polyline>
            </svg>
          </button>
        </div>
      </div>
      <script src="./about.js"></script>
    `
  } 
  
  else if (page.toLowerCase() === 'six-months') {
    content = `
      <main class="padding-l background-accent-1 round shadow-card margin-y-six">
        <h2 class="font-segoe-ui text-orange text-center">Six Month Courses</h2>
        <p class="font-segoe-ui text-s text-center text-orange">
          Our six-month courses provide in-depth, hands-on training and professional development opportunities.
        </p>

        <div class="course-list">
          <!-- First Aid -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">First Aid</h3>
            <p class="font-segoe-ui text-s text-orange">Learn essential first aid awareness and basic life support.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/FirstAid.html">View Details</a>
            </button>
          </section>

          <!-- Sewing -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">Sewing</h3>
            <p class="font-segoe-ui text-s text-orange">Learn to provide garments and new garment tailoring services.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/Sewing.html">View Details</a>
            </button>
          </section>

          <!-- Landscaping -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">Landscaping</h3>
            <p class="font-segoe-ui text-s text-orange">Learn landscaping servicing for new and established gardens.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/Landscaping.html">View Details</a>
            </button>
          </section>
        </div>
      </main>
      <script src="./courses.js"></script>
    `;
  } 
  
  else if (page.toLowerCase() === 'six-weeks') {
    content = `
       <main class="padding-l background-accent-1 round shadow-card">
        <h2 class="font-segoe-ui text-orange text-center">Six Week Courses</h2>
        <p class="font-segoe-ui text-s text-center text-orange">
          Each course runs for six weeks and offers practical, hands-on skills development.
        </p>

        <div class="course-list">
          <!-- Child Minding -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">Child Minding</h3>
            <p class="font-segoe-ui text-s text-orange">Learn how to provide safe basic child and baby care.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/ChildMinding.html">View Details</a>
            </button>
          </section>

          <!-- Cooking -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">Cooking</h3>
            <p class="font-segoe-ui text-s text-orange">Learn to cook and prepare nutritious family meals.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/Cooking.html">View Details</a>
            </button>
          </section>

          <!-- Garden Maintenance -->
          <section class="course-item background-accent-2 round padding-m shadow-card">
            <h3 class="font-segoe-ui text-orange">Garden Maintenance</h3>
            <p class="font-segoe-ui text-s text-orange">Learn the basics of watering, planting, and pruning.</p>
            <button>
              <a class="font-segoe-ui-bold text-decoration-none text-s text-orange hover-underline" href="./Courses/GardenMaintenance.html">View Details</a>
            </button>
          </section>
        </div>
      </main>
      <script src="./courses.js"></script>
    `;
  } 
  
  else if (page.toLowerCase() === 'contact') {
    content = `
      <div id="contact-page">
    <div class="contact-hero">
      <div class="contact-hero-content">
        <p class="contact-intro-text">We're here to help you on your journey. Reach out to us through any of our channels or visit one of our Johannesburg locations. Our dedicated team is ready to assist you with any questions or information you may need.</p>
      </div>
    </div>

    <div class="contact-main">
      <div class="contact-info-box">
        <div class="info-column">
          <h3>Contact Information</h3>
          <div class="info-item">
            <img src="assets/images/chat-icon.png" alt="Chat" class="info-icon">
            <div class="info-text-wrapper">
              <span class="info-label">Get In Touch</span>
            </div>
          </div>
          <div class="info-item">
            <img src="assets/images/clock-icon.png" alt="Hours" class="info-icon">
            <div class="info-text-wrapper">
              <span class="info-label">Operating Hours</span>
            </div>
          </div>
          <div class="info-item">
            <img src="assets/images/email-icon.png" alt="Email" class="info-icon">
            <div class="info-text-wrapper">
              <p>info@empoweringthenation.org.za</p>
            </div>
          </div>
          <div class="info-item">
            <img src="assets/images/phone-icon.png" alt="Phone" class="info-icon">
            <div class="info-text-wrapper">
              <p>+27 11 123 4567</p>
            </div>
          </div>
        </div>

        <div class="map-divider">
          <a href="https://www.google.com/maps/place/123+Empowerment+Street,+Johannesburg+Central" target="_blank" class="map-link">
            <img src="assets/images/headquarters-map.png" alt="Head Office Location Map" class="headquarters-map">
          </a>
        </div>

        <div class="info-column">
          <h3>Head Office</h3>
          <div class="info-item">
            <img src="assets/images/location-icon.png" alt="Location" class="info-icon">
            <div class="info-text-wrapper">
              <p>123 Empowerment Street<br>Johannesburg Central<br>2000 South Africa</p>
            </div>
          </div>
    <div class="info-item">
            <img src="assets/images/train-icon.png" alt="Train" class="info-icon">
            <div class="info-text-wrapper">
              <p>Gautrain: Johannesburg Station<br>Rea Vaya: BRT Line 1A</p>
            </div>
          </div>
          <div class="info-item">
            <img src="assets/images/car-icon.png" alt="Parking" class="info-icon">
            <div class="info-text-wrapper">
              <p>Security: Underground parking available<br>Access from Empowerment Street</p>
            </div>
          </div>
          <div class="info-item">
            <img src="assets/images/info-icon.png" alt="Accessibility" class="info-icon">
            <div class="info-text-wrapper">
              <p>Wheelchair accessible<br>Conference facilities available<br>Free Wi-Fi throughout the building</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="venues-section">
      <div class="venues-container">
        <div class="venue-card">
          <div class="venue-header">
            <h3>Sandton<br>Empowerment Centre</h3>
            <p>Financial District Hub</p>
          </div>
          <div class="venue-body">
            <div class="venue-info-item">
              <img src="assets/images/location-icon.png" alt="Location" class="venue-icon">
              <p>Nelson Mandela Square, Sandton, 2196</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/phone-icon.png" alt="Phone" class="venue-icon">
              <p>+27 11 234 5678</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/email-icon.png" alt="Email" class="venue-icon">
              <p>sandton@empowering.org.za</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/clock-icon.png" alt="Hours" class="venue-icon">
              <p>Mon-Fri: 8:30 AM - 6:00 PM</p>
            </div>
          </div>
          <a href="https://maps.app.goo.gl/XNy7y9i9PU94i1zt9" target="_blank" class="venue-map-link">
            <div class="venue-map">
              <img src="assets/images/sandton-map.png" alt="Sandton Location Map">
            </div>
          </a>
        </div>

        <div class="venue-card">
          <div class="venue-header">
            <h3>Soweto Community<br>Hub</h3>
            <p>Grassroots Development Center</p>
          </div>
          <div class="venue-body">
            <div class="venue-info-item">
              <img src="assets/images/location-icon.png" alt="Location" class="venue-icon">
              <p>Walter Sisulu Square, Kliptown, Soweto, 1801</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/phone-icon.png" alt="Phone" class="venue-icon">
              <p>+27 11 345 6789</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/email-icon.png" alt="Email" class="venue-icon">
              <p>soweto@empowering.org.za</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/clock-icon.png" alt="Hours" class="venue-icon">
              <p>Mon-Sat: 8:00 AM - 5:00 PM</p>
            </div>
          </div>
          <a href="https://maps.app.goo.gl/p6tBCB5T7tg1JHcb7" target="_blank" class="venue-map-link">
            <div class="venue-map">
              <img src="assets/images/soweto-map.png" alt="Soweto Location Map">
            </div>
          </a>
        </div>

        <div class="venue-card">
          <div class="venue-header">
            <h3>Midrand Innovation<br>Centre</h3>
            <p>Technology & Learning Space</p>
          </div>
          <div class="venue-body">
            <div class="venue-info-item">
              <img src="assets/images/location-icon.png" alt="Location" class="venue-icon">
              <p>Gallagher Convention Centre, Midrand, 1685</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/phone-icon.png" alt="Phone" class="venue-icon">
              <p>+27 11 456 7890</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/email-icon.png" alt="Email" class="venue-icon">
              <p>midrand@empowering.org.za</p>
            </div>
            <div class="venue-info-item">
              <img src="assets/images/clock-icon.png" alt="Hours" class="venue-icon">
              <p>Mon-Fri: 9:00 AM - 7:00 PM</p>
            </div>
          </div>
          <a href="https://maps.app.goo.gl/nobuxYbXr2XgD62m8" target="_blank" class="venue-map-link">
            <div class="venue-map">
              <img src="assets/images/midrand-map.png" alt="Midrand Location Map">
            </div>
          </a>
        </div>
      </div>
    </div>
  </div>
    `
  }

  else if (page.toLowerCase() === 'forms') {
    content = `
      <div class="container">
        <h1>SUBMISSION FORM</h1>
        <form>
          <div class="section">
            <h2 class="section-title">Personal Details</h2>
            <div class="form-row">
              <div class="form-group">
                <label for="lastName">Last Name</label>
                <div class="input-wrapper">
                  <img class="input-icon" src="/Web/assets/icons/user-circle.svg" alt="Last Name Icon">
                  <input type="text" id="lastName" placeholder="Enter Last Name">
                </div>
              </div>
              <div class="form-group">
                <label for="firstName">First Name</label>
                <div class="input-wrapper">
                  <img class="input-icon" src="/Web/assets/icons/user-circle.svg" alt="First Name Icon">
                  <input type="text" id="firstName" placeholder="Enter First Name">
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group">
                <label for="email">Email</label>
                <div class="input-wrapper">
                  <img class="input-icon" src="/Web/assets/icons/envelope.svg" alt="Email Icon">
                  <input type="email" id="email" placeholder="Enter Your Email">
                </div>
              </div>
              <div class="form-group">
                <label for="phone">Phone Number</label>
                <div class="input-wrapper">
                  <img class="input-icon" src="/Web/assets/icons/phone.svg" alt="Phone Icon">
                  <input type="tel" id="phone" placeholder="Enter Your Phone Number">
                </div>
              </div>
            </div>
          </div>
          <div class="section">
            <h2 class="section-title">Issue Details</h2>
            <div class="form-group full-width">
              <label for="title">Title</label>
              <div class="input-wrapper">
                <img class="input-icon" src="/Web/assets/icons/document.svg" alt="Title Icon">
                <input type="text" id="title" placeholder="Enter Title">
              </div>
            </div>
            <div class="form-group full-width">
              <label for="issueDetails">Details</label>
              <textarea id="issueDetails" placeholder="Write Anything . . ."></textarea>
            </div>
          </div>
          <div class="section">
            <h2 class="section-title">How Did You Hear About Us?</h2>
            <div class="form-group full-width">
              <label for="leadDetails">Details</label>
              <textarea id="leadDetails" placeholder="Write Anything . . ."></textarea>
            </div>
          </div>
        </form>
      </div>
    `;
  } else {
    content = `<h1>Page Not Found</h1><p>The page "${page}" does not exist.</p>`;
  }

  document.getElementById('content').innerHTML = content;
}

const dropdownToggle = document.getElementById('coursesDropdown');
const dropdownMenu = document.getElementById('dropdownMenu');

dropdownToggle.addEventListener('click', function(event) {
  event.preventDefault();
  dropdownMenu.classList.toggle('show');
});

// Close dropdown if clicking outside
window.addEventListener('click', function(event) {
  if (!dropdownToggle.contains(event.target) && !dropdownMenu.contains(event.target)) {
    dropdownMenu.classList.remove('show');
  }
});

function loadSixWeeks() {
  loadContent('sixweeks/six_weeks');
}

function loadSixMonths() {
  loadContent('sixmonths/six_months');
}

// Individual six-week courses
function loadChildMinding() {
  loadContent('sixweeks/childminding');
}

function loadCooking() {
  loadContent('sixweeks/cooking');
}

function loadGardenMaintenance() {
  loadContent('sixweeks/gardenmaintenance');
}

// Individual six-month courses
function loadFirstAid() {
  loadContent('sixmonths/firstaid');
}

function loadSewing() {
  loadContent('sixmonths/sewing');
}

function loadLandscaping() {
  loadContent('sixmonths/landscaping');
}

function loadLifeSkills() {
  loadContent('sixmonths/lifeskills');
}

// Load Home content on page load
window.onload = function() {
  loadContent('Home');
};
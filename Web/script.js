function loadContent(page) {
  let file = '';
  if (page.toLowerCase() === 'home') {
    document.getElementById('content').innerHTML = '<h1>Welcome Home!</h1><p>This is the home page.</p>';
    return;
  } else if (page.toLowerCase() === 'about') {
    file = 'About/AboutPage.html';
  } else if (page.toLowerCase() === 'courses') {
    file = 'SixMonths.html'; // or another file for courses
  } else if (page.toLowerCase() === 'contact') {
    file = 'Contact/ContactPage.html';
  } else if (page.toLowerCase() === 'form') {
    file = 'FormSubmission/FormSubmission.html';
  }
}
  let content = '';
  if (page === 'Home') {
    content = 
    `
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
    `
  } else if (page === 'About') {
    content = '<h1>About Us</h1><p>Learn more about us here.</p>'; // remove add the about page content here
  } else if (page === 'Courses') {

  } else if (page === 'Forms') {
    content = `<div class="container">
        <h1>SUBMISSION FORM</h1>

        <form>
            <div class="section">
                <h2 class="section-title">
                    Personal Details
                </h2>
                
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
                <h2 class="section-title">
                    Issue Details
                </h2>
                
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
                <h2 class="section-title">
                    How Did You Hear About Us?
                </h2>
                
                <div class="form-group full-width">
                    <label for="leadDetails">Details</label>
                    <textarea id="leadDetails" placeholder="Write Anything . . ."></textarea>
                </div>
            </div>
        </form>
    </div>
    `
  }

}  
function loadContent(page) {
  document.getElementById('content').innerHTML = content;
}

// Load Home content on page load
window.onload = function() {
  loadContent('Home');
};

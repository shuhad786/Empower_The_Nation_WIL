function loadContent(page) {
  let file = '';

  if (page.toLowerCase() === 'home') {
    file = "./Home.html";
  } else if (page.toLowerCase() === 'about') {
    file = "./About/AboutPage.html";
  } else if (page.toLowerCase() === 'six-months') {
    file = "./Courses/SixMonths.html";
  } else if (page.toLowerCase() === 'six-weeks') {
    file = "./Courses/SixWeeks.html";
  } else if (page.toLowerCase() === 'contact') {
    file = "./Contact/ContactPage.html";
  } else if (page.toLowerCase() === 'register') {
    file = "./FormSubmission/calculator.html";
  } else if (page.toLowerCase() === 'sixweeks/childminding') {
    file = "./Courses/ChildMinding.html";
  } else if (page.toLowerCase() === 'sixweeks/cooking') {
    file = "./Courses/Cooking.html";
  } else if (page.toLowerCase() === 'sixweeks/gardenmaintenance') {
    file = "./Courses/GardenMaintenance.html";
  } else if (page.toLowerCase() === 'sixmonths/firstaid') {
    file = "./Courses/FirstAid.html";
  } else if (page.toLowerCase() === 'sixmonths/sewing') {
    file = "./Courses/Sewing.html";
  } else if (page.toLowerCase() === 'sixmonths/landscaping') {
    file = "./Courses/Landscaping.html";
  } else if (page.toLowerCase() === 'sixmonths/lifeskills') {
    file = "./Courses/LifeSkills.html";
  } else {
    document.getElementById('content').innerHTML = `<h1>Page Not Found</h1><p>The page "${page}" does not exist.</p>`;
    return;
  }

  fetch(file)
    .then(response => {
      if (!response.ok) throw new Error(`Failed to load ${file}: ${response.statusText}`);
      return response.text();
    })
    .then(html => {
      document.getElementById('content').innerHTML = html;
    })
    .catch(error => {
      document.getElementById('content').innerHTML = `<p>Error loading page: ${error.message}</p>`;
      console.error(error);
    });
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

// Load Home content on page load
window.onload = function() {
  loadContent('Home');
};

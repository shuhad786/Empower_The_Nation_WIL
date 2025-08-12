function loadContent(page) {
  let content = '';
  if (page === 'Home') {
    content = '<h1>Welcome Home!</h1><p>This is the home page.</p>'; // remove add the home page content here
  } else if (page === 'About') {
    content = '<h1>About Us</h1><p>Learn more about us here.</p>'; // remove add the about page content here
  } else if (page === 'Courses') {
    content = '<h1>Courses</h1><p>Learn more about us here.</p>'; // remove add the courses for both 6 weeks and 12 weeks page content here
  } else if (page === 'Contact') {
    content = '<h1>Contact</h1><p>Contact us at info@example.com.</p>'; // remove add the contact page content here
  }
  document.getElementById('content').innerHTML = content;
}


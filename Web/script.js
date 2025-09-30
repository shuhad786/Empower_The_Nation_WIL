function loadContent(page) {
  let file = '';
  if (page.toLowerCase() === 'home') {
    document.getElementById('content').innerHTML = '<h1>Welcome Home!</h1><p>This is the home page.</p>';
    return;
  } else if (page.toLowerCase() === 'about') {
    file = 'AboutPage.html';
  } else if (page.toLowerCase() === 'courses') {
    file = 'SixMonths.html'; // or another file for courses
  } else if (page.toLowerCase() === 'contact') {
    file = 'ContactPage.html';
  } else if (page.toLowerCase() === 'form') {
    file = 'FormSubmission/FormSubmission.html';
  }

  if (file) {
    fetch(file)
      .then(response => response.text())
      .then(html => {
        document.getElementById('content').innerHTML = html;
      })
      .catch(error => {
        document.getElementById('content').innerHTML = '<p>Error loading page.</p>';
      });
  }
}
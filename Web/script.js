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

  if (file) {
    fetch(file)
      .then(response => response.text())
      .then(html => {
        document.getElementById('content').innerHTML = html;
        
        // Initialize About page carousel if on About page
        if (page.toLowerCase() === 'about') {
          initAboutCarousel();
        }
      })
      .catch(error => {
        document.getElementById('content').innerHTML = '<p>Error loading page.</p>';
      });
  }
}

let currentCarouselIndex = 0;
let carouselSlidesToShow = 4;

function getSlidesToShow() {
  const width = window.innerWidth;
  if (width <= 480) return 1;
  if (width <= 768) return 2;
  return 4;
}

function updateAboutCarousel() {
  const track = document.getElementById('aboutCarouselTrack');
  if (!track) return;
  
  const slides = track.querySelectorAll('.carousel-slide');
  const totalSlides = slides.length;
  carouselSlidesToShow = getSlidesToShow();
  const maxIndex = totalSlides - carouselSlidesToShow;
  
  if (currentCarouselIndex < 0) currentCarouselIndex = 0;
  if (currentCarouselIndex > maxIndex) currentCarouselIndex = maxIndex;
  
  const slideWidth = 100 / carouselSlidesToShow;
  track.style.transform = `translateX(-${currentCarouselIndex * slideWidth}%)`;
  
  const prevBtn = document.querySelector('.prev-btn');
  const nextBtn = document.querySelector('.next-btn');
  
  if (prevBtn) {
    prevBtn.disabled = currentCarouselIndex === 0;
    prevBtn.style.opacity = currentCarouselIndex === 0 ? '0.4' : '1';
  }
  
  if (nextBtn) {
    nextBtn.disabled = currentCarouselIndex >= maxIndex;
    nextBtn.style.opacity = currentCarouselIndex >= maxIndex ? '0.4' : '1';
  }
}

function moveCarousel(direction) {
  currentCarouselIndex += direction;
  updateAboutCarousel();
}

function initAboutCarousel() {
  currentCarouselIndex = 0;
  
  setTimeout(() => {
    const track = document.getElementById('aboutCarouselTrack');
    if (track) {
      updateAboutCarousel();
      
      window.addEventListener('resize', handleCarouselResize);
    }
  }, 100);
}

function handleCarouselResize() {
  currentCarouselIndex = 0;
  updateAboutCarousel();
}

window.moveCarousel = moveCarousel;
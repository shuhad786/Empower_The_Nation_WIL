let currentCarouselIndex = 0;
let carouselSlidesToShow = 3;
let totalSlides = 0;

function getSlidesToShow() {
  const width = window.innerWidth;
  if (width <= 480) return 1;
  if (width <= 768) return 2;
  return 3;
}

function updateAboutCarousel() {
  const track = document.getElementById('aboutCarouselTrack');
  if (!track) return;
  
  const slides = track.querySelectorAll('.carousel-slide');
  totalSlides = slides.length;
  carouselSlidesToShow = getSlidesToShow();

  console.log('Total slides:', totalSlides, 'Slides to show:', carouselSlidesToShow);

  const maxIndex = Math.max(0, totalSlides - carouselSlidesToShow);

  if (currentCarouselIndex < 0) currentCarouselIndex = 0;
  if (currentCarouselIndex > maxIndex) currentCarouselIndex = maxIndex;

  const trackWidth = track.offsetWidth;
  const slideWidth = slides[0] ? slides[0].offsetWidth : 0;
  const gap = parseFloat(getComputedStyle(track).gap) || 16; 

  const offset = currentCarouselIndex * (slideWidth + gap);
  
  console.log('Current index:', currentCarouselIndex, 'Max index:', maxIndex, 'Offset:', offset + 'px');
  console.log('Slide width:', slideWidth, 'Gap:', gap, 'Track width:', trackWidth);
  
  track.style.transform = `translateX(-${offset}px)`;

  const prevBtn = document.querySelector('.prev-btn');
  const nextBtn = document.querySelector('.next-btn');
  
  if (prevBtn) {
    prevBtn.disabled = currentCarouselIndex === 0;
    prevBtn.style.opacity = currentCarouselIndex === 0 ? '0.4' : '1';
    prevBtn.style.cursor = currentCarouselIndex === 0 ? 'not-allowed' : 'pointer';
  }
  
  if (nextBtn) {
    nextBtn.disabled = currentCarouselIndex >= maxIndex;
    nextBtn.style.opacity = currentCarouselIndex >= maxIndex ? '0.4' : '1';
    nextBtn.style.cursor = currentCarouselIndex >= maxIndex ? 'not-allowed' : 'pointer';
  }
}

function moveCarousel(direction) {
  const track = document.getElementById('aboutCarouselTrack');
  if (!track) return;
  
  const slides = track.querySelectorAll('.carousel-slide');
  totalSlides = slides.length;
  carouselSlidesToShow = getSlidesToShow();
  const maxIndex = Math.max(0, totalSlides - carouselSlidesToShow);
  
  currentCarouselIndex += direction;

  if (currentCarouselIndex < 0) {
    currentCarouselIndex = 0;
  }
  if (currentCarouselIndex > maxIndex) {
    currentCarouselIndex = maxIndex;
  }
  
  updateAboutCarousel();
}

function initAboutCarousel() {
  console.log('Initializing carousel...');
  currentCarouselIndex = 0;
  
  const track = document.getElementById('aboutCarouselTrack');
  if (!track) {
    console.error('Carousel track not found!');
    return;
  }
  
  const slides = track.querySelectorAll('.carousel-slide');
  console.log('Found slides:', slides.length);

  const images = track.querySelectorAll('img');
  let loadedImages = 0;
  
  if (images.length === 0) {
    console.warn('No images found in carousel');
    updateAboutCarousel();
    return;
  }
  
  const checkAllLoaded = () => {
    loadedImages++;
    if (loadedImages === images.length) {
      console.log('All images loaded, updating carousel');
      updateAboutCarousel();
    }
  };
  
  images.forEach(img => {
    if (img.complete) {
      checkAllLoaded();
    } else {
      img.addEventListener('load', checkAllLoaded);
      img.addEventListener('error', checkAllLoaded);
    }
  });

  setTimeout(() => {
    updateAboutCarousel();
  }, 500);
  

  window.removeEventListener('resize', handleCarouselResize);

  window.addEventListener('resize', handleCarouselResize);
}

function handleCarouselResize() {
  const oldSlidesToShow = carouselSlidesToShow;
  const newSlidesToShow = getSlidesToShow();

  if (oldSlidesToShow !== newSlidesToShow) {
    currentCarouselIndex = 0;
  }
  
  updateAboutCarousel();
}

window.moveCarousel = moveCarousel;
window.initAboutCarousel = initAboutCarousel;
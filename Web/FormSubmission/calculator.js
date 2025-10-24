// Discount logic based on number of courses selected
function getDiscount(selectedCourses) {
  const courseCount = selectedCourses.length;
  
  if (courseCount >= 3) {
    return 0.15; // 15% discount for 3+ courses
  } else if (courseCount === 2) {
    return 0.05; // 5% discount for 2 courses
  }
  return 0; // No discount for 1 course
}

// Format currency for display
function formatCurrency(amount) {
  return 'R' + amount.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
}

// Initialize calculator - call this AFTER the HTML is injected
function initCalculator() {
  const calculateBtn = document.getElementById('calculateBtn');
  
  if (!calculateBtn) {
    console.log('Calculate button not found yet');
    return;
  }
  
  // Remove any existing listeners to avoid duplicates
  const newBtn = calculateBtn.cloneNode(true);
  calculateBtn.parentNode.replaceChild(newBtn, calculateBtn);
  
  // Add the click event listener
  newBtn.addEventListener('click', function() {
    // Get customer details
    const name = document.getElementById('name').value.trim();
    const phone = document.getElementById('phone').value.trim();
    const email = document.getElementById('email').value.trim();

    // Validate customer details
    if (!name || !phone || !email) {
      document.getElementById('result').style.display = 'block';
      document.getElementById('result').innerHTML = '<b style="color: #d32f2f;">Please fill in all personal details.</b>';
      return;
    }

    // Get selected courses
    const selectedCourses = [];
    document.querySelectorAll('.course-checkbox:checked').forEach(cb => {
      selectedCourses.push({
        name: cb.getAttribute('data-name'),
        fee: parseFloat(cb.getAttribute('data-fee')),
        duration: cb.getAttribute('data-duration')
      });
    });

    // Validate course selection
    if (selectedCourses.length === 0) {
      document.getElementById('result').style.display = 'block';
      document.getElementById('result').innerHTML = '<b style="color: #d32f2f;">Please select at least one course.</b>';
      return;
    }

    // Calculate subtotal
    let subtotal = selectedCourses.reduce((sum, course) => sum + course.fee, 0);

    // Apply discount if applicable
    const discountRate = getDiscount(selectedCourses);
    const discountAmount = subtotal * discountRate;
    const discountedTotal = subtotal - discountAmount;

    // Calculate VAT (15%)
    const vat = discountedTotal * 0.15;
    const total = discountedTotal + vat;

    // Prepare quote/invoice details
    let invoiceHtml = `
      <div style="margin-bottom: 20px;">
        <b>Customer Details:</b>
        <div style="margin-left: 15px; margin-top: 8px; color: #333;">
          <div><strong>Name:</strong> ${name}</div>
          <div><strong>Phone:</strong> ${phone}</div>
          <div><strong>Email:</strong> ${email}</div>
        </div>
      </div>
    `;

    invoiceHtml += `<b>Selected Courses:</b><ul>`;
    selectedCourses.forEach(course => {
      invoiceHtml += `<li>${course.name} (${course.duration}) - ${formatCurrency(course.fee)}</li>`;
    });
    invoiceHtml += `</ul>`;

    invoiceHtml += `<div style="margin-top: 20px; padding-top: 20px; border-top: 2px solid #CB7318;">`;
    invoiceHtml += `<div style="font-size: 1rem; margin-bottom: 8px;"><b>Subtotal:</b> ${formatCurrency(subtotal)}</div>`;
    
    if (discountRate > 0) {
      invoiceHtml += `<div style="font-size: 1rem; margin-bottom: 8px; color: #2e7d32;"><b>Discount (${(discountRate * 100).toFixed(0)}%):</b> -${formatCurrency(discountAmount)}</div>`;
      invoiceHtml += `<div style="font-size: 1rem; margin-bottom: 8px;"><b>Discounted Subtotal:</b> ${formatCurrency(discountedTotal)}</div>`;
    }
    
    invoiceHtml += `<div style="font-size: 1rem; margin-bottom: 8px;"><b>VAT (15%):</b> ${formatCurrency(vat)}</div>`;
    invoiceHtml += `<div style="font-size: 1.3rem; margin-top: 15px; padding: 15px; background: white; border-radius: 8px; border: 2px solid #CB7318;">
      <b>Total Quoted Fee:</b> <span style="color:#CB7318; font-size: 1.5rem;">${formatCurrency(total)}</span>
    </div>`;
    invoiceHtml += `</div>`;
    
    invoiceHtml += `<small style="display: block; margin-top: 20px; padding-top: 15px; border-top: 1px solid #ddd;">
      This is a quoted fee and not a formal invoice. A consultant will contact you to finalize your course booking.
    </small>`;

    // Display the result
    document.getElementById('result').style.display = 'block';
    document.getElementById('result').innerHTML = invoiceHtml;

    // Scroll to result
    document.getElementById('result').scrollIntoView({ behavior: 'smooth', block: 'nearest' });

    // Log for debugging
    console.log('Selected courses:', selectedCourses);
  });
  
  console.log('Calculator initialized successfully');
}
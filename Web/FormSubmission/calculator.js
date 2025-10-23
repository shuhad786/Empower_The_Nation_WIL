// Discount logic: Example - 10% off if 3 or more courses selected
    function getDiscount(selectedCourses) {
      if (selectedCourses.length >= 3) {
        return 0.10; // 10% discount
      }
      return 0;
    }

    document.getElementById('calculateBtn').addEventListener('click', function() {
      const selectedCourses = [];
      document.querySelectorAll('.course:checked').forEach(cb => {
        selectedCourses.push({
          name: cb.getAttribute('data-name'),
          fee: parseFloat(cb.getAttribute('data-fee')),
          duration: cb.getAttribute('data-duration')
        });
      });

      if (selectedCourses.length === 0) {
        document.getElementById('result').style.display = 'block';
        document.getElementById('result').innerHTML = '<b>Please select at least one course.</b>';
        return;
      }

      // Store selected courses in an array (for invoice, etc.)
      // (You can use this array for further processing)
      const courseArray = selectedCourses;

      // Calculate subtotal
      let subtotal = selectedCourses.reduce((sum, course) => sum + course.fee, 0);

      // Apply discount if applicable
      const discountRate = getDiscount(selectedCourses);
      const discountAmount = subtotal * discountRate;
      const discountedTotal = subtotal - discountAmount;

      // Calculate VAT (15%)
      const vat = discountedTotal * 0.15;
      const total = discountedTotal + vat;

      // Prepare invoice/quote details
      let invoiceHtml = `<b>Selected Courses:</b><ul>`;
      selectedCourses.forEach(course => {
        invoiceHtml += `<li>${course.name} (${course.duration}) - R${course.fee.toFixed(2)}</li>`;
      });
      invoiceHtml += `</ul>`;
      invoiceHtml += `<b>Subtotal:</b> R${subtotal.toFixed(2)}<br>`;
      if (discountRate > 0) {
        invoiceHtml += `<b>Discount (${(discountRate*100).toFixed(0)}%):</b> -R${discountAmount.toFixed(2)}<br>`;
      }
      invoiceHtml += `<b>VAT (15%):</b> R${vat.toFixed(2)}<br>`;
      invoiceHtml += `<b>Total Quoted Fee:</b> <span style="color:#2a4d69;">R${total.toFixed(2)}</span><br>`;
      invoiceHtml += `<small>This is a quoted fee and not a formal invoice.</small>`;

      document.getElementById('result').style.display = 'block';
      document.getElementById('result').innerHTML = invoiceHtml;
    });
const customerId = 8;

fetch(`/customers/${customerId}`)
  .then(response => response.json())
  .then(customer => {
    const profile = document.getElementById("customer-profile");

    if (!customer) {
      profile.innerHTML = "<p>No customer found.</p>";
      return;
    }

    profile.innerHTML = `
      <p><strong>ID:</strong> ${customer.id ?? "N/A"}</p>
      <p><strong>First Name:</strong> ${customer.firstName ?? "N/A"}</p>
      <p><strong>Last Name:</strong> ${customer.lastName ?? "N/A"}</p>
      <p><strong>Email:</strong> ${customer.email ?? "N/A"}</p>
      <p><strong>Phone:</strong> ${customer.phone ?? "N/A"}</p>
    `;
  })
  .catch(error => {
    console.error("Error fetching customer profile:", error);
    document.getElementById("customer-profile").innerHTML =
      "<p>Could not load customer information.</p>";
  });
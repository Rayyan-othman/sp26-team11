const params = new URLSearchParams(window.location.search);
const providerId = params.get("id") || 1;

const providerDetails = document.getElementById("provider-details");

Promise.all([
  fetch(`/api/provider/services/${providerId}`).then(res => res.json()),
  fetch(`/api/provider/statistics/${providerId}`).then(res => res.json()),
  fetch(`/api/provider/reviews/${providerId}`).then(res => res.json())
])
  .then(([services, stats, reviews]) => {
    const serviceNames = services.length
      ? services.map(service => service.name ?? service.serviceName ?? service.title ?? "Unnamed Service").join(", ")
      : "No services available";

    const servicesCreated = stats.servicesCreated ?? 0;
    const bookingCount = stats.bookingsForProvider ?? 0;
    const reviewCount = stats.reviewsForProvider ?? 0;

    providerDetails.innerHTML = `
      <p><strong>Provider ID:</strong> ${providerId}</p>
      <p><strong>Services:</strong> ${serviceNames}</p>
      <p><strong>Services Created:</strong> ${servicesCreated}</p>
      <p><strong>Total Bookings:</strong> ${bookingCount}</p>
      <p><strong>Total Reviews:</strong> ${reviewCount}</p>
    `;
  })
  .catch(error => {
    console.error("Error fetching provider details:", error);
    providerDetails.innerHTML = "<p>Could not load provider details.</p>";
  });
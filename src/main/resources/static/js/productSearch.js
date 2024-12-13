document.getElementById("searchButton").addEventListener("click", async () => {
    const query = document.getElementById("searchInput").value.trim();
    const resultsDiv = document.getElementById("productResults");

    resultsDiv.innerHTML = "";

    if (!query) {
        resultsDiv.innerHTML = "<p>Please enter a product name to search.</p>";
        return;
    }

    try {
        // Fetch through your backend endpoint instead of directly to the API
        const response = await fetch(`/search?query=${encodeURIComponent(query)}`, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const products = await response.json();

        if (products.length === 0) {
            resultsDiv.innerHTML = "<p>No products found.</p>";
        } else {
            products.forEach(product => {
                const productCard = document.createElement("div");
                productCard.className = "product-card";
                productCard.innerHTML = `
                    <h2>${product.name}</h2>
                    <p>Price: ${product.price ? `DKK ${product.price.toFixed(2)}` : "N/A"}</p>
                `;
                resultsDiv.appendChild(productCard);
            });
        }
    } catch (error) {
        resultsDiv.innerHTML = `<p>Error: ${error.message}</p>`;
        console.error("An error occurred:", error);
    }
});
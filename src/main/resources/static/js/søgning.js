document.getElementById("searchButton").addEventListener("click", async () => {
    const query = document.getElementById("searchInput").value.trim();
    const resultsDiv = document.getElementById("productResults");

    resultsDiv.innerHTML = "";

    if (!query) {
        resultsDiv.innerHTML = "<p>Please enter a product name to search.</p>";
        return;
    }

    try {
        const apiUrl = `/api/search-results?query=${encodeURIComponent(query)}`;
        const response = await fetch(apiUrl);

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
                    <p>Price: DKK ${product.price.toFixed(2)}</p>
                `;
                resultsDiv.appendChild(productCard);
            });
        }
    } catch (error) {
        resultsDiv.innerHTML = `<p>Error: ${error.message}</p>`;
    }
});

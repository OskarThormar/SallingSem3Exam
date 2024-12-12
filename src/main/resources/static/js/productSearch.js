document.getElementById("searchButton").addEventListener("click", async () => {
    const query = document.getElementById("searchInput").value.trim();
    const resultsDiv = document.getElementById("productResults");

    resultsDiv.innerHTML = "";

    if (!query) {
        resultsDiv.innerHTML = "<p>Please enter a product name to search.</p>";
        return;
    }
    const fetchApiUrl = async () => {
        try {
            const response = await fetch('http://localhost:8080/api-token');
            if (!response.ok) {
                throw new Error(`HttpError! Status: ${response.status}`);
            }
            const url = await response.text();
            console.log(url);
            return url;
        } catch (error) {
            console.error('Error fetching', error);
        }
    };
    const token = "147a8413-74cf-4914-bd28-e94dbc2fd1a5";
    const fetchApi = fetch("/api-token")
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch API token URL");
            }
            return response.text(); // Hent API URL som en streng
        })
    const apiUrl = fetchApiUrl() + "=" + encodeURIComponent(query);
    const response = await fetch(apiUrl, {
        method: "GET",
        headers:{
            'Authorization': `Bearer ${token}` // Brug backticks her
        }
    });

    try {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        const products = data.suggestions || [];

        if (products.length === 0) {
            resultsDiv.innerHTML = "<p>No products found.</p>";
        } else {
            products.forEach(product => {
                const productCard = document.createElement("div");
                productCard.className = "product-card";
                productCard.innerHTML = `
                    <h2>${product.title}</h2>
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

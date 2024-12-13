document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('searchInput');
    const searchButton = document.getElementById('searchButton');
    const loader = document.getElementById('loader');
    const productResults = document.getElementById('productResults');

    searchButton.addEventListener('click', searchProducts);
    searchInput.addEventListener('keypress', (event) => {
        if (event.key === 'Enter') {
            searchProducts();
        }
    });

    async function searchProducts() {
        const query = searchInput.value.trim();
        if (!query) {
            alert('Please enter a product name');
            return;
        }
        // Clear previous results
        productResults.innerHTML = '';
        // Show loader
        loader.style.display = 'block';
        try {
            const response = await fetch(`/searchProductPrice?query=${encodeURIComponent(query)}`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json'
                }
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const products = await response.json();
            // Hide loader
            loader.style.display = 'none';
            // Display results
            if (products.length > 0) {
                products.forEach(product => {
                    productResults.innerHTML += `
                    <div class="product-card">
                        <h2>${product.name}</h2>
                        <p>Price: ${product.price} kr</p>
                    </div>
                `;
                });
            } else {
                productResults.innerHTML = '<p>No products found.</p>';
            }
        } catch (error) {
            // Hide loader
            loader.style.display = 'none';
            console.error('Error:', error);
            productResults.innerHTML = `<p>Error fetching products: ${error.message}</p>`;
        }
    }
});
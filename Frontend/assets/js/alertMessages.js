document.addEventListener('DOMContentLoaded', function() {
    // Define the HTML content as a template literal
    // <link rel="stylesheet" href="http://127.0.0.1:5500/"http://127.0.0.1:5500/assets/css/style.css"
 
 
   
    const showalertHTML = `
    <link rel="stylesheet" href="http://127.0.0.1:5500/assets/css/alert_style.css">
    <div id="customshowalert" class="overlay" style="display: none;">
        <div class="showalert-box">
            <p id="showalertMessage">Message goes here</p>
            <button id="okButton">OK</button>
        </div>
    </div>
    `;

    // Insert the HTML content into the body
    document.body.insertAdjacentHTML('beforeend', showalertHTML);

    // Define showalert function
    window.showalert = function(message, callback) {
        document.getElementById('showalertMessage').textContent = message;
        document.getElementById('customshowalert').style.display = 'flex';
        
        // Store the callback function
        window.alertCallback = callback;
    };

    // Define hideshowalert function
    window.hideshowalert = function() {
        document.getElementById('customshowalert').style.display = 'none';

        // Call the callback function if it exists
        if (typeof window.alertCallback === 'function') {
            window.alertCallback();
            // Clear the callback function
            window.alertCallback = null;
        }
    };

    // Attach the hideshowalert function to the OK button
    document.getElementById('okButton').addEventListener('click', hideshowalert);
});

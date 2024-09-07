
        // Sample data
        var data = [
          ["Jacob", "Photoshop", "28.76%", "Pending","Jacob", "Photoshop", "28.76%", "Pending","Jacob", "Photoshop", "28.76%", "Pending","Jacob", "Photoshop", "28.76%", "Pending"]
        ];
      
        // Variables for pagination
        var currentPage = 1;
        var rowsPerPage = 2; // Change this value as needed
      
        // Function to populate the table with data
        function populateTable() {
          var tableBody = document.querySelector("#dataTable tbody");
          tableBody.innerHTML = "";
      
          var start = (currentPage - 1) * rowsPerPage;
          var end = start + rowsPerPage;
      
          for (var i = start; i < end && i < data.length; i++) {
            var row = document.createElement("tr");
            for (var j = 0; j < data[i].length; j++) {
              var cell = document.createElement("td");
              cell.textContent = data[i][j];
              row.appendChild(cell);
            }
            tableBody.appendChild(row);
          }
        }
      
        // Function to update pagination
        function updatePagination() {
          var totalPages = Math.ceil(data.length / rowsPerPage);
          var paginationElement = document.getElementById("pagination");
          paginationElement.innerHTML = "";
      
          for (var i = 1; i <= totalPages; i++) {
            var listItem = document.createElement("li");
            listItem.textContent = i;
            listItem.addEventListener("click", function () {
              currentPage = parseInt(this.textContent);
              populateTable();
              updatePagination();
            });
            paginationElement.appendChild(listItem);
          }
        }
      
        // Initial setup
        populateTable();
        updatePagination();

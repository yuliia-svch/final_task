function sort(){
     var list, i, switching, b, shouldSwitch;
              list = document.getElementById("id01");
              b = list.getElementsByTagName("tr");
              for(i = 1; i < b.length; i++) {
                b[i].style.display="table";
              }
              switching = true;
              while (switching) {
                switching = false;
                for (i = 1; i < (b.length - 1); i++) {
                  city1 = b[i].getElementsByTagName("td");
                  city2 = b[i+1].getElementsByTagName("td");
                  shouldSwitch = false;
                  if (city1[0].innerHTML.toLowerCase() > city2[0].innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                  }
                }
                if (shouldSwitch) {
                  b[i].parentNode.insertBefore(b[i + 1], b[i]);
                  switching = true;
                }
              }
        }
        function filter(){
            var sel = document.getElementById("filter");
            var filter = sel.value.toLowerCase();
            var list = document.getElementById("id01");
            var b = list.getElementsByTagName("tr");
            for (i = 1; i < b.length; i++) {
                b[i].style.display="table";
            }
            for (i = 1; i < b.length; i++) {
                city = b[i].getElementsByTagName("td");
                txtValue = city[0].textContent || city[0].innerText;
                if (txtValue.toLowerCase().indexOf(filter) <= -1) {
                    b[i].style.display="none";
                }
            }
        }

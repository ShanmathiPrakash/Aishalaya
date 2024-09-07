$(document).ready(function () 
{
  // Get the current page URL
  var currentUrl = window.location.href;

  // Check each navigation link and compare with the current URL
  $(".nav-link").each(function () 
  {
    var linkUrl = $(this).attr("href");

    if (currentUrl.indexOf(linkUrl) !== -1) 
      {
      // Add the 'active' class to the parent <li> element
      $(this).closest("li").addClass("active");

      // If there are multiple levels of navigation, you may need to handle them differently
      // For example, if you have sub-menu items:
      $(this).parents(".collapse").addClass("show");
    }
  });
});

     $(function() 
     {
        $("#includeHtml").load("http://192.168.0.139:5500/pages/header.html");
        $("#includeFooder").load("http://192.168.0.139:5500/pages/fooder.html");
     });








     
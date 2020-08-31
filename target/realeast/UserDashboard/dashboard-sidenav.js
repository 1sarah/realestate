<body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
    const menuIconEl = $('.menu-icon');
    const sidenavEl = $('.sidenav');
    const sidenavCloseEl = $('.sidenav__close-icon');

    // Add and remove provided class names
    function toggleClassName(el, className) {
      if (el.hasClass(className)) {
        el.removeClass(className);
      } else {
        el.addClass(className);
      }
    }
    // Open the side nav on click
    menuIconEl.on('click', function() {
      toggleClassName(sidenavEl, 'active');
    });

    // Close the side nav on click
    sidenavCloseEl.on('click', function() {
      toggleClassName(sidenavEl, 'active');
    });
  </script>
</body>
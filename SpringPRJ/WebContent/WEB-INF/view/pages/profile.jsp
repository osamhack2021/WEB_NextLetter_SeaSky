<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Next Letter</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

      <a href="/" class="logo d-flex align-items-center">
        <span>Next Letter</span>
        <img src="assets/img/logo.png" alt="">
      </a>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="/">Home</a></li>
          <li><a class="nav-link scrollto" href="editprofile.do">정보수정</a></li>
          <li><a class="nav-link scrollto" href="/" onclick="sessionStorage.removeItem('login');">로그아웃</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <main id="main">
    <!-- ======= Blog Section ======= -->
    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="col-12 text-center my-3">
            <img id="profile_image" alt="profile-image" class="img-fluid img-thumbnail my-3">

            <h1><strong id="user_name">GUEST</strong></h1>
      
            <p id="user_statusMsg">
              GUEST의 한마디!!
            </p>

            
            <a href="#" onclick="copyToClipboard('/linkpage.do?user_no=1');"><i class="ri-share-line" style="font-size: 2rem;"></i></a>
          </div>

          <div class="col-lg-9 entries mx-auto my-4">
          
          <c:forEach var="mDTO" items="${messageList}" varStatus="status">
	          <article class="entry">
	            <h2 class="entry-title">
	              <a href="#">${mDTO.title}</a>
	            </h2>
	
	            <div class="entry-meta">
	              <ul>
	                <li class="d-flex align-items-center"><i class="bi bi-person"></i> <a href="#">(${mDTO.relation}) ${mDTO.sender}</a></li>
	                <li class="d-flex align-items-center"><i class="bi bi-clock"></i> <a href="#"><time datetime="2020-01-01">${mDTO.reg_dt}</time></a></li>
	              </ul>
	            </div>
	
	            <div class="entry-content">
	              <p>
	                ${mDTO.content}
	              </p>
	            </div>
	
	          </article><!-- End blog entry -->
		  </c:forEach>

          </div><!-- End blog entries list -->

        </div>

      </div>
    </section><!-- End Blog Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>OSAM2021 SeaSky Team</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/flexstart-bootstrap-startup-template/ -->
        Developed by <a href="https://github.com/osamhack2021/WEB_NextLetter_SeaSky/">SeaSky</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="js/profile.js"></script>
  
  <script>
	    $(document).ready(function(){
	    	//프로필 이미지 설정
	    	const profile_int = Math.floor(Math.random() * 3) + 1;
	    	document.getElementById('profile_image').src = 'img/profile' + profile_int + '.png';
	    	
	    	//정보설정
	    	setInfo('statusMsg,name');
	    });
   </script>

</body>

</html>
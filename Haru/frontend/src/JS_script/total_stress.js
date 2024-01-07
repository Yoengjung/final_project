// // 스트레스 수치 입력 변수
// var number = 85;
// // Limites hautes des paliers
// var paliers = [10,20,30,40,50,60,70,80,90,100];
//
// var palierLength = paliers.length;
// // Durée de l'animation d'un palier (ms)
// var palierTime = 400;
// // Vitesse de la boucle (ms)
// var frameTime = 10;
// // Nombre d'étapes dans un palier (fps)
// var speed = palierTime / frameTime;
//
// var loop;
//
// var $sliderScroll = $('.slider-scroll');
// var $sliderScrollDiv = $('div',$sliderScroll);
// var $pourcentage = $('.pourcentage');
//
// slider();
//
// function slider() {
//   var count = 0;
//   var palierRef = 0;
//   setTimeout(function(){
//     $sliderScrollDiv.addClass('reveal');
//   },300);
//   loop = setInterval(function(){
//     var palierMin = 0;
//     var palierDif = paliers[palierRef];
//     if (palierRef > 0) {
//       palierMin = paliers[palierRef - 1] + 1;
//       palierDif = paliers[palierRef] - paliers[palierRef - 1];
//     }
//     var num = palierMin + palierDif / speed * count;
//     if (num >= number) {
//       num = stop();
//     }
//     if ((num >= paliers[palierRef]) && (number >= paliers[palierRef])) {
//       palierRef++;
//       count = 0;
//       if (palierRef == palierLength) {
//         num = stop();
//       } else {
//         $pourcentage.removeClass('txt-pink');
//         $('.slider-bar li:eq('+palierRef+') .pourcentage').addClass('txt-pink');
//       }
//     }
//     var pourcentage = (palierRef * 100 / palierLength) + (100 / palierLength / speed * count);
//     $('#stress-rate',$sliderScrollDiv).html(Math.round(num) + ' %');
//     $sliderScroll.css({width:pourcentage + '%'});
//     count ++;
//   },frameTime);
// }
//
// function stop() {
//   $sliderScrollDiv.addClass('stop');
//   clearInterval(loop);
//   return number;
// }
//
// // 오른쪽으로 스크롤
// function scrollRight() {
//   var container = document.querySelector('.recomend-place');
//   container.scrollTo({
//       left: container.scrollWidth,
//       behavior: 'smooth'
//   });
// }
//
// // 왼쪽으로 스크롤
// function scrollLeft() {
//   var container = document.querySelector('.recomend-place');
//   container.scrollTo({
//       left: 0,
//       behavior: 'smooth'
//   });
// }
//
// // 오른쪽으로 스크롤 버튼 클릭 이벤트 리스너 등록
// document.getElementById('scroll-right-button').addEventListener('click', scrollRight);
//
// // 왼쪽으로 스크롤 버튼 클릭 이벤트 리스너 등록
// document.getElementById('scroll-left-button').addEventListener('click', scrollLeft);

$(window).on("load",function(){$(function(){var c=$(".gallery-wrp > div.row");c.isotope({masonry:{columnWidth:1}});var d=$(".masnory2");d.isotope({masonry:{columnWidth:0.3}});var b=$(".fltrs-lst"),a=b.find("a");a.click(function(){var f=$(this);if(f.hasClass("selected")){return false}var e=f.parents(".fltrs-lst");e.find(".selected").removeClass("selected");f.addClass("selected");var h={},g=e.attr("data-option-key"),i=f.attr("data-option-value");i=i==="false"?false:i;h[g]=i;if(g==="layoutMode"&&typeof changeLayoutMode==="function"){changeLayoutMode(f,h)}else{c.isotope(h);d.isotope(h)}return false})})});
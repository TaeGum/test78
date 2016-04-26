/**
 * 
 */

var header_height   = $("div[data-role='header']:visible").outerHeight();
var footer_height   = $("div[data-role='footer']:visible").outerHeight();
var content = $("div[data-role='content']:visible");          
var content_height  = $(window).height() - header_height - footer_height;            
 
content_height -= (content.outerHeight() - content.height());   
$("div[data-role='content']").css("height", content_height);

$('.thumbnail').nailthumb();
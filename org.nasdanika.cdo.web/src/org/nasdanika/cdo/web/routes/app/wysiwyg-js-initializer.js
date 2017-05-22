jQuery(function() {
	var element = $("{{selector}}");
	element.wysiwyg({
	    class: 'fake-bootstrap',
	    toolbar: 'top-focus',
	    buttons: {
            // Fontname plugin
//            fontname: {
//                title: 'Font',
//                image: '\uf031', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                popup: function( $popup, $button ) {
//                        var list_fontnames = {
//                                // Name : Font
//                                'Arial, Helvetica' : 'Arial,Helvetica',
//                                'Verdana'          : 'Verdana,Geneva',
//                                'Georgia'          : 'Georgia',
//                                'Courier New'      : 'Courier New,Courier',
//                                'Times New Roman'  : 'Times New Roman,Times'
//                            };
//                        var $list = $('<div/>').addClass('wysiwyg-plugin-list')
//                                               .attr('unselectable','on');
//                        $.each( list_fontnames, function( name, font ) {
//                            var $link = $('<a/>').attr('href','#')
//                                                .css( 'font-family', font )
//                                                .html( name )
//                                                .click(function(event) {
//                                                    $(element).wysiwyg('shell').fontName(font).closePopup();
//                                                    // prevent link-href-#
//                                                    event.stopPropagation();
//                                                    event.preventDefault();
//                                                    return false;
//                                                });
//                            $list.append( $link );
//                        });
//                        $popup.append( $list );
//                       },
//                //showstatic: true,    // wanted on the toolbar
//                showselection: true    // wanted on selection
//            },
//            // Fontsize plugin
//            fontsize: {
//                title: 'Size',
//                style: 'color:white;background:red',      // you can pass any property - example: "style"
//                image: '\uf034', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                popup: function( $popup, $button ) {
//                        // Hack: http://stackoverflow.com/questions/5868295/document-execcommand-fontsize-in-pixels/5870603#5870603
//                        var list_fontsizes = [];
//                        for( var i=8; i <= 11; ++i )
//                            list_fontsizes.push(i+'px');
//                        for( var i=12; i <= 28; i+=2 )
//                            list_fontsizes.push(i+'px');
//                        list_fontsizes.push('36px');
//                        list_fontsizes.push('48px');
//                        list_fontsizes.push('72px');
//                        var $list = $('<div/>').addClass('wysiwyg-plugin-list')
//                                               .attr('unselectable','on');
//                        $.each( list_fontsizes, function( index, size ) {
//                            var $link = $('<a/>').attr('href','#')
//                                                .html( size )
//                                                .click(function(event) {
//                                                    $(element).wysiwyg('shell').fontSize(7).closePopup();
//                                                    $(element).wysiwyg('container')
//                                                            .find('font[size=7]')
//                                                            .removeAttr("size")
//                                                            .css("font-size", size);
//                                                    // prevent link-href-#
//                                                    event.stopPropagation();
//                                                    event.preventDefault();
//                                                    return false;
//                                                });
//                            $list.append( $link );
//                        });
//                        $popup.append( $list );
//                       }
//                //showstatic: true,    // wanted on the toolbar
//                //showselection: true    // wanted on selection
//            },
//            // Header plugin
//            header: {
//                title: 'Header',
//                style: 'color:white;background:blue',      // you can pass any property - example: "style"
//                image: '\uf1dc', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                popup: function( $popup, $button ) {
//                        var list_headers = {
//                                // Name : Font
//                                'Header 1' : '<h1>',
//                                'Header 2' : '<h2>',
//                                'Header 3' : '<h3>',
//                                'Header 4' : '<h4>',
//                                'Header 5' : '<h5>',
//                                'Header 6' : '<h6>',
//                                'Code'     : '<pre>'
//                            };
//                        var $list = $('<div/>').addClass('wysiwyg-plugin-list')
//                                               .attr('unselectable','on');
//                        $.each( list_headers, function( name, format ) {
//                            var $link = $('<a/>').attr('href','#')
//                                                 .css( 'font-family', format )
//                                                 .html( name )
//                                                 .click(function(event) {
//                                                    $(element).wysiwyg('shell').format(format).closePopup();
//                                                    // prevent link-href-#
//                                                    event.stopPropagation();
//                                                    event.preventDefault();
//                                                    return false;
//                                                });
//                            $list.append( $link );
//                        });
//                        $popup.append( $list );
//                       }
//                //showstatic: true,    // wanted on the toolbar
//                //showselection: false    // wanted on selection
//            },
            bold: {
                title: 'Bold (Ctrl+B)',
                image: '\uf032', // <img src="path/to/image.png" width="16" height="16" alt="" />
                hotkey: 'b'
            },
            italic: {
                title: 'Italic (Ctrl+I)',
                image: '\uf033', // <img src="path/to/image.png" width="16" height="16" alt="" />
                hotkey: 'i'
            },
            underline: {
                title: 'Underline (Ctrl+U)',
                image: '\uf0cd', // <img src="path/to/image.png" width="16" height="16" alt="" />
                hotkey: 'u'
            },
            strikethrough: {
                title: 'Strikethrough (Ctrl+S)',
                image: '\uf0cc', // <img src="path/to/image.png" width="16" height="16" alt="" />
                hotkey: 's'
            },
            forecolor: {
                title: 'Text color',
                image: '\uf1fc' // <img src="path/to/image.png" width="16" height="16" alt="" />
            },
            highlight: {
                title: 'Background color',
                image: '\uf043' // <img src="path/to/image.png" width="16" height="16" alt="" />
            },
//            alignleft: {
//                title: 'Left',
//                image: '\uf036', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                //showstatic: true,    // wanted on the toolbar
//                showselection: false    // wanted on selection
//            },
//            aligncenter: {
//                title: 'Center',
//                image: '\uf037', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                //showstatic: true,    // wanted on the toolbar
//                showselection: false    // wanted on selection
//            },
//            alignright: {
//                title: 'Right',
//                image: '\uf038', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                //showstatic: true,    // wanted on the toolbar
//                showselection: false    // wanted on selection
//            },
//            alignjustify: {
//                title: 'Justify',
//                image: '\uf039', // <img src="path/to/image.png" width="16" height="16" alt="" />
//                //showstatic: true,    // wanted on the toolbar
//                showselection: false    // wanted on selection
//            },
            subscript: {
                title: 'Subscript',
                image: '\uf12c', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: true    // wanted on selection
            },
            superscript: {
                title: 'Superscript',
                image: '\uf12b', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: true    // wanted on selection
            },
            indent: {
                title: 'Indent',
                image: '\uf03c', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: false    // wanted on selection
            },
            outdent: {
                title: 'Outdent',
                image: '\uf03b', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: false    // wanted on selection
            },
            orderedList: {
                title: 'Ordered list',
                image: '\uf0cb', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: false    // wanted on selection
            },
            unorderedList: {
                title: 'Unordered list',
                image: '\uf0ca', // <img src="path/to/image.png" width="16" height="16" alt="" />
                //showstatic: true,    // wanted on the toolbar
                showselection: false    // wanted on selection
            },
            removeformat: {
                title: 'Remove format',
                image: '\uf12d' // <img src="path/to/image.png" width="16" height="16" alt="" />
            }
        }
	});

	// surrounding div:
	element.wysiwyg('container');

	// accessing 'wysiwyg.js':
	element.wysiwyg('shell').bold();
	element.wysiwyg('shell').forecolor( '#ff0000' );
	element.wysiwyg('shell').getElement().style.height="10em";
});

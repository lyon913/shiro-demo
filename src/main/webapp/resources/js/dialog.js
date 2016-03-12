
(function($){
	$.fn.center = function () {
	    this.css("position","absolute");
	    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	    return this;
	}	
})(jQuery);


(function($) {
    $.fn.drags = function(opt) {

        opt = $.extend({
            handle: "",
            cursor: "move",
            draggableClass: "draggable",
            activeHandleClass: "active-handle"
        }, opt);

        var $selected = null;
        var $elements = (opt.handle === "") ? this : this.find(opt.handle);

        $elements.css('cursor', opt.cursor).on("mousedown", function(e) {
            if(opt.handle === "") {
                $selected = $(this);
                $selected.addClass(opt.draggableClass);
            } else {
                $selected = $(this).parent();
                $selected.addClass(opt.draggableClass).find(opt.handle).addClass(opt.activeHandleClass);
            }
            var drg_h = $selected.outerHeight(),
                drg_w = $selected.outerWidth(),
                pos_y = $selected.offset().top + drg_h - e.pageY,
                pos_x = $selected.offset().left + drg_w - e.pageX;
            $(document).on("mousemove", function(e) {
                $selected.offset({
                    top: e.pageY + pos_y - drg_h,
                    left: e.pageX + pos_x - drg_w
                });
            }).on("mouseup", function() {
                $(this).off("mousemove"); // Unbind events from document
                if ($selected !== null) {
                    $selected.removeClass(opt.draggableClass);
                    $selected = null;
                }
            });
            e.preventDefault(); // disable selection
        }).on("mouseup", function() {
            if(opt.handle === "") {
                $selected.removeClass(opt.draggableClass);
            } else {
                $selected.removeClass(opt.draggableClass)
                    .find(opt.handle).removeClass(opt.activeHandleClass);
            }
            $selected = null;
        });

        return this;

    };
})(jQuery);



function dialog(opt) {
	var me = this;

	this.dialogId = opt.dialogId;
	this.title = opt.title;
	this.width = opt.width;
	this.height = opt.height;

	this.dialogDiv = $('<div class="dialog"></div>');
	this.dialogDiv.attr('id',this.dialogId);
	this.dialogDiv.width(this.width);
	this.dialogDiv.height(this.height);
	this.dialogDiv.hide();

	this.titleDiv = $('<div class="dialogTitle"></div>');
	this.titleDiv.html(this.title);
	this.closeButton = $('<div class="dialogClose">×</div>');
	this.closeButton.click(function() {
		me.close();
	});

	this.titleDiv.append(this.closeButton);
	this.dialogDiv.append(this.titleDiv);

	this.contentDiv = $('<div class="dialogContent"></div>');
	this.dialogDiv.append(this.contentDiv);

	$('body').append(this.dialogDiv);

	this.dialogDiv.drags({
		handle : '.dialogTitle'
	});
	
	this.setContent = function(html) {
		me.contentDiv.html(html);
	};

	this.openUrl = function(url, type, data) {
		$.ajax({
			url : url,
			type : type,
			dataType : 'html',
			data : data,
			success : function(response) {
				me.setContent(response);
				me.show();
			},
			error : function(response) {
				console.log(response.responseText);
			}
		});
		
	};

	this.openHtml = function(html) {
		me.setContent(html);
		me.show();
	};
	
	this.openElement = function(element) {
		me.setContent('');
		me.contentDiv.append(element);
		me.show();
	};
	
	this.show = function(){
		me.dialogDiv.center();
		me.dialogDiv.show();
	}

	this.hide = function() {
		me.dialogDiv.hide();
	};

	this.close = function() {
		me.dialogDiv.empty();
		me.dialogDiv.remove();
	};

}


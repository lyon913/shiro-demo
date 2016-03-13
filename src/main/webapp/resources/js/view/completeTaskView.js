/**
 * 
 */

function CompleteTaskView(ctx, data, selCbk) {
	// 模板通过ajax加载，此对象使用deferred
	var dtd = $.Deferred();
	var me = this;
	this.ctx = ctx;
	this.data = data;
	this.templateUrl = this.ctx
			+ '/resources/js/view/completeTaskView.html';

	$.ajax({
		url : me.templateUrl,
		type : 'get'
	}).done(function(templateHtml) {

		// 编译模板
		me.template = $.templates(templateHtml);

		// 数据绑定
		me.viewElement = me.template.link($('<div></div>'), me.data);
		;

		// 创建对话框
		var d = new dialog({
			dialogId : '',
			title : '提交业务',
			width : 400,
			height : 200
		});

		// 绑定模板中的button事件处理
		me.viewElement.find('.selectButton').on('click', function() {
			var view = $.view(this);
			// view是users节点，需要返回的是包含outNode的父节点
			var data = view.parent.parent.data;
			console.log(data);

			var msg = "确认发送流程到『 " + data.outNode.name + "  』节点";
			if (data.users && data.users.length) {
				msg += "-『" + data.users[0].name + "』";
			}
			if (confirm(msg)) {
				selCbk(data);
				d.close();
			}
		});
		d.openElement(me.viewElement);
		// 模板加载完成，延迟对象解决
		dtd.resolve();
	}).fail(function(data) {
		console.log('加载模板错误')
		dtd.reject();
	});

	this.getViewElement = function() {
		return me.viewElement;
	};

	return dtd.promise(this);
}
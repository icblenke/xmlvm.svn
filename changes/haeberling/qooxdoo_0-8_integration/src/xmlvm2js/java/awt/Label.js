qx.Class.define("java_awt_Label", {
	extend: java_awt_Component,
	construct: function() {
		this.qxLabel = new qx.ui.basic.Label();
	},
	members:
	{
		
		qxLabel: 0,
		$$init_: function() {
		},
		$$init____java_lang_String: function(title) {
			this.qxLabel.setText(title.$str);
		},
		$$init____java_lang_String_int: function(title, alignment) {
			this.qxLabel.setText(title.$str);
			if(alignment == 0)
				alignment = "left";
			this.qxLabel.setAlign(alignment, "middle");
		},
		$setText___java_lang_String: function(text) {
			this.qxLabel.setText(text.$str);
		},
		$getText: function() {
			return new java_lang_String(this.qxLabel.getText());
		},
		getQx: function() {
			return this.qxLabel;
		},
		$setBounds___int_int_int_int : function(x, y, width, height) {
			this.qxLabel.setLocation(x, y);
			this.qxLabel.setDimension(width, height);
		},
		$setFont___java_awt_Font: function(font) {
		}
	}
});

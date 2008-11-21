qx.Class.define("java_awt_Frame", {
	extend: java_awt_Window,
	construct: function () {
		this.anchor = document.getElementById("XML11_ROOT");
		if(this.anchor != undefined){
			console.log("Embedding Window into XML11_ROOT");
			this.xml11Embeded = true;
			this.qxCanvas = new qx.ui.container.Composite(new qx.ui.layout.Basic());
			this.anchor.id = "XML11_ROOT_OCCUPIED";
		}else{
			this.xml11Embeded = false;
			this.qxComponent = new qx.ui.window.Window("...");
			this.qxComponent.setContentPadding(0);
			this.qxComponent.setLayout(new qx.ui.layout.Basic());
			//this.qxCanvas = new qx.ui.container.Composite(new qx.ui.layout.Basic());
			//this.qxWindow.add(this.qxCanvas);
			//this.qxCanvas.setLocation(0,-10);
			//Right now we don't support minimizing, as windows would
			//go to nowhere
			this.qxComponent.setAllowMinimize(false);
		}
	},
	members:
	{
		qxWindow: 0,
		xml11Embeded: 0,
		xml11Anchor: 0,
		width: 0,
		height: 0,
		//This Canvas layout is used to correct a difference in layouting
		//between AWT and qooxdoo. In AWT coordinate (0,0) is in the upper
		//left corner of the window, which also includes the title bar. In
		//order to place a widget into the visible area, you have to push it
		//down a little. In qooxdoo (0,0) is beneath this title bar. So we use
		//a CanvasLayout to push AWT elements up a little again.
		//TODO
		qxCanvas: 0,
		layoutManager: 0,
		$$init_: function() {
//			this.qxWindow.addEventListener("appear", function(e) {
//				document.getElementsByTagName("body")[0].style.backgroundColor = "#FFFFFF";
//			});
		},
		$$init____java_lang_String: function(title) {
			this.$$init_();
			if(!this.xml11Embeded)
				this.qxComponent.setCaption(title.$str);
		},
		$pack: function() {
		},
		$setVisible___boolean: function(visible) {
			var frame = this;
			if(visible) {
				//If XML11_ROOT is defined, the main window is expected to be embedded
				if(this.xml11Embeded){
					//this.qxWindow.addToDocument();
				}else {
					//this.qxWindow.addToDocument();
					this.qxComponent.open();
				}
			}else{
				this.qxComponent.close();
			}
		},
		$setResizable___boolean: function(resizable) {
			if(this.xml11Embeded)
				return;
			if(resizable == 0) resizable = false;
			else resizable = true;
			this.qxComponent.setResizable(resizable, resizable, resizable, resizable);
		},
		$setSize___java_awt_Dimension: function(size) {
			this.$setSize___int_int(size.$getWidth(), size.$getHeight());
		},
		$setSize___int_int: function(width, height) {
			// Compensates the native title bar of the window.
			//this.qxCanvas.setUserBounds(-10, -30, width + 10, height + 30);
			this.qxComponent.setWidth(width);
			this.qxComponent.setHeight(height + 30);
			this.width = width;
			this.height = height;
		},
		$setBounds___int_int_int_int: function(x, y, width, height) {
			// TODO: What to do with x and y???
			this.$setSize___int_int(width, height);
			/*
			// Compensates the native title bar of the window.
			this.qxCanvas.setUserBounds(-10, -30, width + 10, height + 30);
			this.qxWindow.setWidth(width);
			this.qxWindow.setHeight(height);
			this.width = width;
			this.height = height;
			*/
		},
		$setTitle___java_lang_String: function(title) {
			if(this.xml11Embeded) {
				return;
			}
			this.qxComponent.setCaption(title.$str);
		},
		$setBackground___java_awt_Color: function(color) {
			if(color == undefined){
				this.qxComponent.setBackgroundColor("white");
				return;
			}
			console.log("SPECIAL COLOR!: rgb(" + color.r + "," + color.g + "," + color.b + ")");
			this.qxComponent.setBackgroundColor("rgb(" + color.r + "," + color.g + "," + color.b + ")");
		},
		$getWidth: function() {
			return this.qxComponent.getWidth();
		},
		$getHeight: function() {
			return this.qxComponent.getHeight();
		},
		$setLocation___int_int: function(x, y) {
			this.qxComponent.setUserBounds(x, y, this.width, this.height);
		},
		$validate: function() {
			//Is there a need to implement this?
		}
	}
});
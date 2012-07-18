function VManager() {

    this.startupVManager = function() {
        n_VM = this;
        n_windowGroup = new HashMap();


    }

    this.newUrlWindow = function() {
        var url = document.getElementById("url").value;
        var win = $.window({
	    title: "" + url,
            url: "" + url,
            onClose: function(wnd) {
                n_windowGroup.remove(wnd.getTitle());
            }
        });


        win.show();

    }
    this.newWindow = function(url) {
        if (n_windowGroup.get(url)) {

            if (n_windowGroup.get(url).isMinimized()) {
                this.unMinimize(url);

            } else {
                n_windowGroup.get(url).show();
            }


        } else {

        var win = $.window({
		title: "" + url,
                url: "" + url,
                onClose: function(wnd) {
                    n_windowGroup.remove(wnd.getTitle());
                }
            });

            n_windowGroup.put(url, win);

            win.show();

        }

    }

    this.getActiveWindow = function() {
        return $.window.getSelectedWindow();

    }

    this.anyWindowActive = function(){
	var x = $.window.getAll();
	for(var y in x){
		if(!x[y].isMinimized()){
			return true;
		}
	}
	return false;
    }

    this.getWindow = function(winid) {
        return n_windowGroup.get(winid);

    }
    this.bringWindowToFront = function() {
        var url = document.getElementById("url").value; //falt


    }
    this.unMinimize = function(url) {
        if (url == null) {
            var url = document.getElementById("url").value;
        }
        n_windowGroup.get(url).restore();
    }

}

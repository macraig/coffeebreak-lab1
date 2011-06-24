function InfoMarker() {
    this.marker = null;
    this.infoWindow = null;
    this.startupInfoMarker = function(marker, infoWindow) {
        this.marker = marker;
        this.infoWindow = infoWindow;
        return this;
    }
}

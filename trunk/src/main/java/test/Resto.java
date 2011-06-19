package test;

public class Resto
{
    String name;
    String address;
    String latitud;
    String longitud;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public boolean isEmpty()
    {
        return !(name != null && address != null && latitud != null && longitud != null);
    }

    @Override
    public String toString() {
        return ("<place><name>".concat(name).concat("</name><address>").concat(address).concat("</address><latitude>").concat(latitud).concat("</latitude><longitude>").concat(longitud).concat("</longitude></place>")) ;
    }
}

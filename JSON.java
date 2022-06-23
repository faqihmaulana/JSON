public class JSoneAPI {
    public static void main(String[] args) throws IOException {
        String Download;
        String Ulasan;
        String Address;
        String Phone;

        ArrayList<Students> _studentTI = new ArrayList<>();
        try {
            Students s = new Students();
            Scanner _input = new Scanner(System.in);
            System.out.print("Download  : ");
            NIM = _input.nextLine();
            System.out.print("Ulasan  : ");
            Name = _input.nextLine();
            System.out.print("Addres : ");
            Address = _input.nextLine();
            System.out.print("Phone : ");
            Phone = _input.nextLine();

            s.set_nim(DDownload);
            s.set_name(Ulasan);
            s.set_address(Address);
            s.set_phone(Phone);
            _GooglePlay.add(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int j=0;j< _GooglePlay.size();j++){
            System.out.println(_GooglePlay.get(j).get_Download() + " - "+_GooglePlay.get(j).get_Ulasan() + " - "
                    +_GooglePlay.get(j).get_address() + " - "+_GooglePlay.get(j).get_phone() + " - ");
        }

        //mengubah ArrayList menjadi Format JSDN
        JSONArray jsonStudent= new JSONArray();
        JSONObject myJObject = new JSONObject();
        myJObject.put("Download",_GooglePlay.get(0).get_Download());
        myJObject.put("Ulasan",_GooglePlay.get(0).get_Ulasan());
        myJObject.put("address",_GooglePlay.get(0).get_address());
        myJObject.put("phone",_GooglePlay.get(0).get_phone());
        jsonStudent.put(myJObject);

        System.out.println(jsonStudent.toString());

        // Send Student data to database Cloud
        ConnectURL myUriBuilder = new ConnectURL();
        URL myAddress = myUriBuilder.buildURL("https://gplaystore.p.rappidat.com/applicationDeetails");
        myUriBuilder.postJSON(myAddress,jsonStudent.toString());

    }
}
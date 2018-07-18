public void exportDatabaseToMail() {
   // init realm
        Realm realm = Realm.getDefaultInstance();

        File exportRealmFile = null;
        try {
            // get or create an "export.realm" file
            exportRealmFile = new File(this.getExternalCacheDir(), "export.realm");

            // if "export.realm" already exists, delete
            exportRealmFile.delete();

            // copy current realm to "export.realm"
            realm.writeCopyTo(exportRealmFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        realm.close();

        // init email intent and add export.realm as attachment
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, "csvega250@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "ccc");
        intent.putExtra(Intent.EXTRA_TEXT, "cccc");
        Uri u = Uri.fromFile(exportRealmFile);
        intent.putExtra(Intent.EXTRA_STREAM, u);

        // start email intent
        startActivity(Intent.createChooser(intent, "YOUR CHOOSER TITLE"));
}

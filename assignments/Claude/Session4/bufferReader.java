interface DateAdapter {
  string getDate();
  string getFileType();
};

class DateAdapterImpl implements DateAdapter {
  private Buffer buffer;

  @override
  public String getDate() {
    return convertDate(buffer.getDate(), buffer.getFileType());
  }

  private convertDate(String date, String fileType ) {
    if (fileType == "ISO 8601") {
      DateFormat formatter = new SimpleDateFormat("YY-MM-DD");
      return formatter.format(date);
    }
    else {
      DateFormat formatter = new SimpleDateFormat("YY/MM/DD");
      return formatter.format(date);
    }
  }

}

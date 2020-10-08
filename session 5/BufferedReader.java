interface Buffer {
    public String formatNonISO();
}

class MemoryCacheBuffer implements Buffer {
    String content;

    public String formatNonISO() {
        SimpleDateFormat simpleDateformatter = new SimpleDateFormate("YY/MM/DD");
        System.out.println(simpleDateformatter.format(content));
        return content;
    };
}

// yy-mm-dd
interface FileBuffer { // target interface
    // FileBuffer dont provide nonISO format
    // only ISO
    public String fromatISO();
}

class FileMemoryBuffer implements FileBuffer {
    String content;
    public String fromatISO() {
        return content;
    }
}

// 2 incompatible interfaces need to interact with each other
class FileMemoryAdapter implements FileBuffer {
    Buffer memoryCacheBuffer;
    public FileMemoryAdapter(Buffer memoryCacheBuffer) {
        this.memoryCacheBuffer = memoryCacheBuffer;
    }

    // cross reference to formatting of the fileBuffer
    // translating from nonISO to ISO format
    public String fromatISO() {
        // translate the methods appropriately
        String outputNonISO = memoryCacheBuffer.formatNonISO();
        // re-format outputNonISO to ISO
        SimpleDateFormat simpleDateformatter = new SimpleDateFormate("YY-MM-DD");
        String formattedISO = simpleDateformatter.format(content)
        System.out.println(formattedISO);
        return formattedISO;
    }
}

class Client {
    public static void main(String args[]) {
        Buffer memoryCacheBuffer = new MemoryCacheBuffer();
        FileBuffer fileMemoryBuffer = new FileMemoryBuffer();

        // Wrap a Buffer in a fileMemoryAdapter such that it behaves like FileBuffer an ISOFormatter
        FileBuffer fileMemoryAdapter = new FileMemoryAdapter(memoryCacheBuffer);

        System.out.println("Buffer...");
        memoryCacheBuffer.formatNonISO();

        System.out.println("FileBuffer...");
        fileMemoryBuffer.formatISO();

        // FileBuffer behaving like a buffer
        System.out.println("FileMemoryAdapter...");
        fileMemoryAdapter.fromatISO();
    }
}
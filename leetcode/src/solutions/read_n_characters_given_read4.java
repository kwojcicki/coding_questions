
package solutions;

class read_n_characters_given_read4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        char[] readBuf = new char[4];
        while(read < n){
            int actuallyRead = read4(readBuf);
            int i = 0;
            while(i < actuallyRead && read < buf.length){
                buf[read++] = readBuf[i++];
            }
            if(actuallyRead < 4) break;
        }

        return Math.min(read, n);
    }
}

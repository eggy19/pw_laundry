/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_laundry;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author aidil
 */
class textLimit extends PlainDocument{
        private int limit;
        textLimit(int limit) {
            super();
            this.limit = limit;
        }

        textLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }
        
        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
        return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
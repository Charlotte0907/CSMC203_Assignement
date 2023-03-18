/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/17/2023
 * Platform/compiler:eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Marie-Charlotte Agbogbe
*/


package Assignment3;
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		char x;
		for (int i = 0; i<plainText.length(); i++) {
			x = plainText.charAt(i);
		if ((x<LOWER_RANGE)||(x >UPPER_RANGE))
			{
				return false;
			}
		}
		//throw new RuntimeException("method not implemented");// has to be removed before implementation
	return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		if (isStringInBounds(plainText)) 
		{
			char x, y; 			
					int old;
					String nvst = "";
						for (int j = 0; j<plainText.length(); j++) 
						{
							x = plainText.charAt(j);
						 old = (int)x + key;	
						 
							while(old > UPPER_RANGE)
							{
								old-=RANGE; 
							}
							while(old < LOWER_RANGE)
							{
								old+=RANGE; 
							}
	
						y = (char) old;
						nvst += y; 
						}
						return nvst;
			}
		
		
			return "The selected string is not in bounds, Try again.";
	
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {		
		String encrypt = "" ;
		int key ;
		
		 int x,y,z;
		 for (int i = 0; i<plainText.length(); i++) {
				x = plainText.charAt(i);
				
				z =i%bellasoStr.length();
				y = bellasoStr.charAt(z);
		 
						
					 key = x+y;  
				 
				 while (key> UPPER_RANGE)
				 {
					 key -= RANGE ; 
				 }
				 encrypt += (char) key;		
			
		}
		 return encrypt;
	}
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		String decrypt= "";	
		
			char x, y; 
			int old;
			
				for (int i = 0; i<encryptedText.length(); i++) 
				{
					x = encryptedText.charAt(i);
				 old = (int)x -key;	
				 
						while(old > UPPER_RANGE)
						{
							old-=RANGE; 
						}
						while(old < LOWER_RANGE)
						{
							old+=RANGE; 
						}
				y = (char) old;
				decrypt += y; 
				}
				return decrypt;		
		
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String plainText ="";
		int x,y,z;
		int key;
		 for (int i = 0; i<encryptedText.length(); i++) {
				x = encryptedText.charAt(i);
				
				z =i%bellasoStr.length();
				y = bellasoStr.charAt(z);
				key = x-y;  
				 
					 while (key< LOWER_RANGE)
					 {
						 key += RANGE ; 
					 }
				 plainText += (char) key;		
			
		}
		 return plainText;
	
		
	}
}

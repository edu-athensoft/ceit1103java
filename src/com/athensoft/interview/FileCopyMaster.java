package com.athensoft.interview;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class FileCopyMaster {

	public static void main(String[] args) {
		final String basePath = "d:\\temp\\interview";
		final String srcDir = "Master";
		Path parent = Paths.get(basePath);
		Path src = Paths.get(basePath+File.separator+srcDir);
//		Path dest = Paths.get("d:\\temp\\interview\\dest");
		
		try {
			Files.newDirectoryStream( parent ).forEach( d -> {
				if( Files.isDirectory( d )) {
					boolean notParent = !d.toString().startsWith(parent.toString()+File.separator+srcDir);
					boolean notMaster = !d.toString().equals(parent.toString());
					if(notParent && notMaster) {
						System.out.println(d.toString());
						copyAll(src, d);
					}
				} 
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//copyAll(src, dest);

	}
	
	public static void copyAll(final Path src, final Path dest) {
	    try {
	        Files.walk( src ).forEach( s -> {
	            try {
	                Path d = dest.resolve( src.relativize(s) );
	                if( Files.isDirectory( s ) ) {
	                    if( !Files.exists( d ) )
	                        Files.createDirectory( d );
	                    return;
	                }
	                Files.copy( s, d, REPLACE_EXISTING );// use flag to override existing
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        });
	    } catch( Exception ex ) {
	        ex.printStackTrace();
	    }
	}

}

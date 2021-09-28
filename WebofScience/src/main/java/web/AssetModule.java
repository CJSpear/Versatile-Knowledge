/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 *
 * @author yeah2
 */
public class AssetModule extends Jooby{
      public AssetModule() {
        assets("/WebofScience*.html");
        assets("/WebofScience/public/css/*.css");
        assets("/WebofScience/public/js/*.js");


        // make index.html the default page

        // prevent 404 errors due to browsers requesting favicons
        get("/favicon.ico", () -> Results.noContent());
    }
}

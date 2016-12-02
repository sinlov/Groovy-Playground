package com.sinlov.groovy.utils

import groovy.xml.MarkupBuilder

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)
xml.langs(type:"current", count:3, mainstream:true){
    language(flavor:"static", version:"1.5", "Java")
    language(flavor:"dynamic", version:"1.6.0", "Groovy")
    language(flavor:"dynamic", version:"1.9", "JavaScript")
}
def writer = new FileWriter("simple.xml")
print sw

writer.withWriter {
    line -> [1].each{
        line << sw
    }
}
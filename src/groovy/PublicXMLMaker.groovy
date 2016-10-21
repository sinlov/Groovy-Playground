import groovy.xml.StreamingMarkupBuilder

def comment = "<![CDATA[<!-- address is new to this release -->]]>"
def builder = new StreamingMarkupBuilder()
builder.encoding = "UTF-8"

def person = {
    mkp.xmlDeclaration()
    mkp.pi("xml-stylesheet": "type='text/xsl' href='myfile.xslt'")
    mkp.declareNamespace('': 'http://myDefaultNamespace')
    mkp.declareNamespace('location': 'http://someOtherNamespace')
    person(id: 100) {
        firstname("Jane")
        lastname("Doe")
        mkp.yieldUnescaped(comment)
        location.address("123 Main")
    }
}
def writer = new FileWriter("person.xml")
print builder.bind(person).toString()
writer << builder.bind(person)
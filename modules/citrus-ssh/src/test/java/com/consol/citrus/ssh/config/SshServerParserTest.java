package com.consol.citrus.ssh.config;

import com.consol.citrus.ssh.config.SshServerParser;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.Test;
import org.w3c.dom.Element;

import static org.easymock.EasyMock.*;

/**
 * @author roland
 * @since 05.09.12
 */
public class SshServerParserTest {

    @Test
    public void simple() {
        SshServerParser parser = new SshServerParser();

        Element element = createMock(Element.class);
        for (int i =0; i < SshServerParser.ATTRIBUTE_PROPERTY_MAPPING.length; i+=2) {
            expect(element.getAttribute(SshServerParser.ATTRIBUTE_PROPERTY_MAPPING[i])).andReturn("bla");
        }
        expect(element.getAttribute("message-handler-ref")).andReturn(null);
        replay(element);
        parser.parseInternal(element, null);
    }
}
package hudson.plugins.jacoco.model;

import hudson.XmlFile;
import hudson.model.Run;
import hudson.plugins.jacoco.AbstractJacocoTestBase;
import hudson.plugins.jacoco.JacocoBuildAction;
import hudson.util.LogTaskListener;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoverageGraphLayoutTest extends AbstractJacocoTestBase {

    private static final Logger logger = Logger.getLogger(CoverageGraphLayoutTest.class.getName());
    private static final String TEST_RESOURCES = "src/test/resources/";

    @Test
    public void serialization() throws IOException {

        final JacocoBuildAction action = new JacocoBuildAction(null, null, new LogTaskListener(logger, Level.ALL)
                , null, null, null);
        new XmlFile(Run.XSTREAM, new File(TEST_RESOURCES + "jacocobuildaction.xml")).unmarshal(action);

        assertEquals(3, action.getCoverageGraphLayout().getPlots().size());
        assertEquals(Color.orange, action.getCoverageGraphLayout().getPlots().get(2).getColor());

        assertEquals(getExpected(), Run.XSTREAM.toXML(action));
        //same except of xml header and whitespace
        //assertEquals(FileUtils.readFileToString(new File(TEST_RESOURCES + "jacocobuildaction.xml")), Run.XSTREAM.toXML(action));
    }

    private String getExpected() {
        return "<hudson.plugins.jacoco.JacocoBuildAction>\n" +
                "  <clazz>\n" +
                "    <missed>1728</missed>\n" +
                "    <covered>1627</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </clazz>\n" +
                "  <method>\n" +
                "    <missed>13150</missed>\n" +
                "    <covered>7541</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </method>\n" +
                "  <line>\n" +
                "    <missed>38050</missed>\n" +
                "    <covered>25772</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </line>\n" +
                "  <complexity>\n" +
                "    <missed>18714</missed>\n" +
                "    <covered>9210</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </complexity>\n" +
                "  <instruction>\n" +
                "    <missed>207727</missed>\n" +
                "    <covered>151396</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </instruction>\n" +
                "  <branch>\n" +
                "    <missed>9602</missed>\n" +
                "    <covered>4773</covered>\n" +
                "    <initialized>true</initialized>\n" +
                "  </branch>\n" +
                "  <maxClazz>1</maxClazz>\n" +
                "  <maxMethod>1</maxMethod>\n" +
                "  <maxLine>1</maxLine>\n" +
                "  <maxComplexity>1</maxComplexity>\n" +
                "  <maxInstruction>1</maxInstruction>\n" +
                "  <maxBranch>1</maxBranch>\n" +
                "  <failed>false</failed>\n" +
                "  <inclusions>\n" +
                "    <string></string>\n" +
                "  </inclusions>\n" +
                "  <exclusions>\n" +
                "    <string></string>\n" +
                "  </exclusions>\n" +
                "  <thresholds>\n" +
                "    <minClass>0</minClass>\n" +
                "    <maxClass>0</maxClass>\n" +
                "    <minMethod>0</minMethod>\n" +
                "    <maxMethod>0</maxMethod>\n" +
                "    <minLine>0</minLine>\n" +
                "    <maxLine>0</maxLine>\n" +
                "    <minBranch>0</minBranch>\n" +
                "    <maxBranch>0</maxBranch>\n" +
                "    <minInstruction>0</minInstruction>\n" +
                "    <maxInstruction>0</maxInstruction>\n" +
                "    <minComplexity>0</minComplexity>\n" +
                "    <maxComplexity>0</maxComplexity>\n" +
                "  </thresholds>\n" +
                "  <coverageGraphLayout>\n" +
                "    <baseStroke>2.0</baseStroke>\n" +
                "    <axes serialization=\"custom\">\n" +
                "      <unserializable-parents/>\n" +
                "      <vector>\n" +
                "        <default>\n" +
                "          <capacityIncrement>0</capacityIncrement>\n" +
                "          <elementCount>3</elementCount>\n" +
                "          <elementData>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "              <crop>50</crop>\n" +
                "              <skipZero>true</skipZero>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "              <crop>5</crop>\n" +
                "              <skipZero>true</skipZero>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "              <crop>5</crop>\n" +
                "              <skipZero>true</skipZero>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "          </elementData>\n" +
                "        </default>\n" +
                "      </vector>\n" +
                "    </axes>\n" +
                "    <plots serialization=\"custom\">\n" +
                "      <unserializable-parents/>\n" +
                "      <vector>\n" +
                "        <default>\n" +
                "          <capacityIncrement>0</capacityIncrement>\n" +
                "          <elementCount>3</elementCount>\n" +
                "          <elementData>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "              <value>PERCENTAGE</value>\n" +
                "              <type>BRANCH</type>\n" +
                "              <axis reference=\"../../../../../../axes/vector/default/elementData/hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis\"/>\n" +
                "              <color>\n" +
                "                <red>0</red>\n" +
                "                <green>0</green>\n" +
                "                <blue>255</blue>\n" +
                "                <alpha>255</alpha>\n" +
                "              </color>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "              <value>MISSED</value>\n" +
                "              <type>BRANCH</type>\n" +
                "              <axis reference=\"../../../../../../axes/vector/default/elementData/hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis[2]\"/>\n" +
                "              <color>\n" +
                "                <red>255</red>\n" +
                "                <green>0</green>\n" +
                "                <blue>0</blue>\n" +
                "                <alpha>255</alpha>\n" +
                "              </color>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "            <hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "              <value>MISSED</value>\n" +
                "              <type>LINE</type>\n" +
                "              <axis reference=\"../../../../../../axes/vector/default/elementData/hudson.plugins.jacoco.model.CoverageGraphLayout_-Axis[3]\"/>\n" +
                "              <color>\n" +
                "                <red>255</red>\n" +
                "                <green>200</green>\n" +
                "                <blue>0</blue>\n" +
                "                <alpha>255</alpha>\n" +
                "              </color>\n" +
                "            </hudson.plugins.jacoco.model.CoverageGraphLayout_-Plot>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "            <null/>\n" +
                "          </elementData>\n" +
                "        </default>\n" +
                "      </vector>\n" +
                "    </plots>\n" +
                "  </coverageGraphLayout>\n" +
                "</hudson.plugins.jacoco.JacocoBuildAction>";
    }
}
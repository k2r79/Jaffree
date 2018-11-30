package com.github.kokorin.jaffree.ffprobe;

import com.github.kokorin.jaffree.ffprobe.data.DSection;
import com.github.kokorin.jaffree.ffprobe.data.Data;

import java.util.Collections;
import java.util.List;

public class FFprobeResult {
    private final Data data;

    public FFprobeResult(Data data) {
        this.data = data;
    }

    public ProgramVersion getProgramVersion() {
        DSection section = data.getSection("PROGRAM_VERSION");
        if (section == null) {
            return null;
        }

        return new ProgramVersion(section);
    }

    public Format getFormat() {
        DSection section = data.getSection("FORMAT");
        if (section == null) {
            return null;
        }

        return new Format(section);
    }

    public Error getError() {
        DSection section = data.getSection("ERROR");
        if (section == null) {
            return null;
        }

        return new Error(section);
    }

    public List<LibraryVersion> getLibraryVersions() {
        return data.getSections("LIBRARY_VERSION", new DSection.SectionConverter<LibraryVersion>() {
            @Override
            public LibraryVersion convert(DSection dSection) {
                return new LibraryVersion(dSection);
            }
        });
    }

    public List<PixelFormat> getPixelFormats() {
        return Collections.emptyList();
    }

    public List<Packet> getPackets() {
        return data.getSections("PACKET", new DSection.SectionConverter<Packet>() {
            @Override
            public Packet convert(DSection dSection) {
                return new Packet(dSection);
            }
        });
    }

    public List<Frame> getFrames() {
        return data.getSections("FRAME", new DSection.SectionConverter<Frame>() {
            @Override
            public Frame convert(DSection dSection) {
                return new Frame(dSection);
            }
        });
    }

    public List<Subtitle> getSubtitles() {
        return data.getSections("SUBTITLE", new DSection.SectionConverter<Subtitle>() {
            @Override
            public Subtitle convert(DSection dSection) {
                return new Subtitle(dSection);
            }
        });
    }

    public List<Program> getPrograms() {
        return data.getSections("PROGRAM", new DSection.SectionConverter<Program>() {
            @Override
            public Program convert(DSection dSection) {
                return new Program(dSection);
            }
        });
    }

    public List<Stream> getStreams() {
        return data.getSections("STREAM", new DSection.SectionConverter<Stream>() {
            @Override
            public Stream convert(DSection dSection) {
                return new Stream(dSection);
            }
        });
    }

    public List<Chapter> getChapters() {
        return Collections.emptyList();
    }
}

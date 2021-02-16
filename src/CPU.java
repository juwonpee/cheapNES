public class CPU {
    private byte a;                                 // accumulator
    private byte x;                                 // x index register
    private byte y;                                 // y index register
    private byte st;                                // stack pointer (only on first page)
    private short pc;                               // program counter
    private byte flags;

    public CPU() {
        // registers
        a = 0x00;
        x = 0x00;
        y = 0x00;
        st = 0x00;
        pc = 0x0000;
        flags = 0x00;
    }

    // clock called from NES class
    public boolean clock(byte opcode) {
        return false;
    }
    private byte fetch(short address) {
        return 0;
    }

    public interface opcode {
        void opcodeRun();
    }
    private opcode[] opcodeLookup = new opcode[] {
        new opcode() { public void opcodeRun() { BRK(); IMM(); }},         // 0x00
        new opcode() { public void opcodeRun() { ORA(); IZX(); }},         // 0x01
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x02
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x03
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x04
        new opcode() { public void opcodeRun() { ORA(); ZP0(); }},         // 0x05
        new opcode() { public void opcodeRun() { ASL(); ZP0(); }},         // 0x06
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x07
        new opcode() { public void opcodeRun() { PHP(); IMP(); }},         // 0x08
        new opcode() { public void opcodeRun() { ORA(); IMM(); }},         // 0x09
        new opcode() { public void opcodeRun() { ASL(); IMP(); }},         // 0x0A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x0B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x0C
        new opcode() { public void opcodeRun() { ORA(); ABS(); }},         // 0x0D
        new opcode() { public void opcodeRun() { ASL(); ABS(); }},         // 0x0E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x0F

        new opcode() { public void opcodeRun() { BPL(); REL(); }},         // 0x10
        new opcode() { public void opcodeRun() { ORA(); IZY(); }},         // 0x11
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x12
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x13
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x14
        new opcode() { public void opcodeRun() { ORA(); ZPX(); }},         // 0x15
        new opcode() { public void opcodeRun() { ASL(); ZPX(); }},         // 0x16
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x17
        new opcode() { public void opcodeRun() { CLC(); IMP(); }},         // 0x18
        new opcode() { public void opcodeRun() { ORA(); ABY(); }},         // 0x19
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x1A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x1B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x1C
        new opcode() { public void opcodeRun() { ORA(); ABX(); }},         // 0x1D
        new opcode() { public void opcodeRun() { ASL(); ABX(); }},         // 0x1E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x1F

        new opcode() { public void opcodeRun() { JSR(); ABS(); }},         // 0x20
        new opcode() { public void opcodeRun() { AND(); IZX(); }},         // 0x21
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x22
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x23
        new opcode() { public void opcodeRun() { BIT(); ZP0(); }},         // 0x24
        new opcode() { public void opcodeRun() { AND(); ZP0(); }},         // 0x25
        new opcode() { public void opcodeRun() { ROL(); ZP0(); }},         // 0x26
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x27
        new opcode() { public void opcodeRun() { PLP(); IMP(); }},         // 0x28
        new opcode() { public void opcodeRun() { AND(); IMM(); }},         // 0x29
        new opcode() { public void opcodeRun() { ROL(); IMP(); }},         // 0x2A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x2B
        new opcode() { public void opcodeRun() { BIT(); ABS(); }},         // 0x2C
        new opcode() { public void opcodeRun() { AND(); ABS(); }},         // 0x2D
        new opcode() { public void opcodeRun() { ROL(); ABS(); }},         // 0x2E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x2F

        new opcode() { public void opcodeRun() { BMI(); REL(); }},         // 0x30
        new opcode() { public void opcodeRun() { AND(); IZY(); }},         // 0x31
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x32
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x33
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x34
        new opcode() { public void opcodeRun() { AND(); ZPX(); }},         // 0x35
        new opcode() { public void opcodeRun() { ROL(); ZPX(); }},         // 0x36
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x37
        new opcode() { public void opcodeRun() { SEC(); IMP(); }},         // 0x38
        new opcode() { public void opcodeRun() { AND(); ABY(); }},         // 0x39
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x3A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x3B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x3C
        new opcode() { public void opcodeRun() { AND(); ABX(); }},         // 0x3D
        new opcode() { public void opcodeRun() { ROL(); ABX(); }},         // 0x3E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x3F

        new opcode() { public void opcodeRun() { RTI(); IMP(); }},         // 0x40
        new opcode() { public void opcodeRun() { EOR(); IZX(); }},         // 0x41
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x42
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x43
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x44
        new opcode() { public void opcodeRun() { EOR(); ZP0(); }},         // 0x45
        new opcode() { public void opcodeRun() { LSR(); ZP0(); }},         // 0x46
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x47
        new opcode() { public void opcodeRun() { PHA(); IMP(); }},         // 0x48
        new opcode() { public void opcodeRun() { EOR(); IMM(); }},         // 0x49
        new opcode() { public void opcodeRun() { LSR(); IMP(); }},         // 0x4A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x4B
        new opcode() { public void opcodeRun() { JMP(); ABS(); }},         // 0x4C
        new opcode() { public void opcodeRun() { EOR(); ABS(); }},         // 0x4D
        new opcode() { public void opcodeRun() { LSR(); ABS(); }},         // 0x4E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x4F

        new opcode() { public void opcodeRun() { BVC(); REL(); }},         // 0x50
        new opcode() { public void opcodeRun() { EOR(); IZY(); }},         // 0x51
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x52
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x53
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x54
        new opcode() { public void opcodeRun() { EOR(); ZPX(); }},         // 0x55
        new opcode() { public void opcodeRun() { LSR(); ZPX(); }},         // 0x56
        new opcode() { public void opcodeRun() { XXX(); NOP(); }},         // 0x57
        new opcode() { public void opcodeRun() { CLI(); IMP(); }},         // 0x58
        new opcode() { public void opcodeRun() { EOR(); ABY(); }},         // 0x59
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x5A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x5B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x5C
        new opcode() { public void opcodeRun() { EOR(); ABX(); }},         // 0x5D
        new opcode() { public void opcodeRun() { LSR(); ABX(); }},         // 0x5E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x5F

        new opcode() { public void opcodeRun() { RTS(); IMP(); }},         // 0x60
        new opcode() { public void opcodeRun() { ADC(); IZX(); }},         // 0x61
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x62
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x63
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x64
        new opcode() { public void opcodeRun() { ADC(); ZP0(); }},         // 0x65
        new opcode() { public void opcodeRun() { ROR(); ZP0(); }},         // 0x66
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x67
        new opcode() { public void opcodeRun() { PLA(); IMP(); }},         // 0x68
        new opcode() { public void opcodeRun() { ADC(); IMM(); }},         // 0x69
        new opcode() { public void opcodeRun() { ROR(); IMP(); }},         // 0x6A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x6B
        new opcode() { public void opcodeRun() { JMP(); IND(); }},         // 0x6C
        new opcode() { public void opcodeRun() { ADC(); ABS(); }},         // 0x6D
        new opcode() { public void opcodeRun() { ROR(); ABS(); }},         // 0x6E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x6F

        new opcode() { public void opcodeRun() { BVS(); REL(); }},         // 0x70
        new opcode() { public void opcodeRun() { ADC(); IZY(); }},         // 0x71
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x72
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x73
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x74
        new opcode() { public void opcodeRun() { ADC(); ZPX(); }},         // 0x75
        new opcode() { public void opcodeRun() { ROR(); ZPX(); }},         // 0x76
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x77
        new opcode() { public void opcodeRun() { SEI(); IMP(); }},         // 0x78
        new opcode() { public void opcodeRun() { ADC(); ABY(); }},         // 0x79
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x7A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x7B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x7C
        new opcode() { public void opcodeRun() { ADC(); ABX(); }},         // 0x7D
        new opcode() { public void opcodeRun() { ROR(); ABX(); }},         // 0x7E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x7F

        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x80
        new opcode() { public void opcodeRun() { STA(); IZX(); }},         // 0x81
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x82
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x83
        new opcode() { public void opcodeRun() { STY(); ZP0(); }},         // 0x84
        new opcode() { public void opcodeRun() { STA(); ZP0(); }},         // 0x85
        new opcode() { public void opcodeRun() { STX(); ZP0(); }},         // 0x86
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x87
        new opcode() { public void opcodeRun() { DEY(); IMP(); }},         // 0x88
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x89
        new opcode() { public void opcodeRun() { TXA(); IMP(); }},         // 0x8A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x8B
        new opcode() { public void opcodeRun() { STY(); ABS(); }},         // 0x8C
        new opcode() { public void opcodeRun() { STA(); ABS(); }},         // 0x8D
        new opcode() { public void opcodeRun() { STX(); ABS(); }},         // 0x8E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x8F

        new opcode() { public void opcodeRun() { BCC(); REL(); }},         // 0x90
        new opcode() { public void opcodeRun() { STA(); IZY(); }},         // 0x91
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x92
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x93
        new opcode() { public void opcodeRun() { STY(); ZPX(); }},         // 0x94
        new opcode() { public void opcodeRun() { STA(); ZPX(); }},         // 0x95
        new opcode() { public void opcodeRun() { STX(); ZPY(); }},         // 0x96
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x97
        new opcode() { public void opcodeRun() { TYA(); IMP(); }},         // 0x98
        new opcode() { public void opcodeRun() { STA(); ABY(); }},         // 0x99
        new opcode() { public void opcodeRun() { TXS(); IMP(); }},         // 0x9A
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x9B
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0x9C
        new opcode() { public void opcodeRun() { STA(); ABX(); }},         // 0x9D
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x9E
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0x9F
        
        new opcode() { public void opcodeRun() { LDY(); IMM(); }},         // 0xA0
        new opcode() { public void opcodeRun() { LDA(); IZX(); }},         // 0xA1
        new opcode() { public void opcodeRun() { LDX(); IMM(); }},         // 0xA2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xA3
        new opcode() { public void opcodeRun() { LDY(); ZP0(); }},         // 0xA4
        new opcode() { public void opcodeRun() { LDA(); ZP0(); }},         // 0xA5
        new opcode() { public void opcodeRun() { LDX(); ZP0(); }},         // 0xA6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xA7
        new opcode() { public void opcodeRun() { TAY(); IMP(); }},         // 0xA8
        new opcode() { public void opcodeRun() { LDA(); IMM(); }},         // 0xA9
        new opcode() { public void opcodeRun() { TAX(); IMP(); }},         // 0xAA
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xAB
        new opcode() { public void opcodeRun() { LDY(); ABS(); }},         // 0xAC
        new opcode() { public void opcodeRun() { LDA(); ABS(); }},         // 0xAD
        new opcode() { public void opcodeRun() { LDX(); ABS(); }},         // 0xAE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xAF

        new opcode() { public void opcodeRun() { BCS(); REL(); }},         // 0xB0
        new opcode() { public void opcodeRun() { LDA(); IZY(); }},         // 0xB1
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xB2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xB3
        new opcode() { public void opcodeRun() { LDY(); ZPX(); }},         // 0xB4
        new opcode() { public void opcodeRun() { LDA(); ZPX(); }},         // 0xB5
        new opcode() { public void opcodeRun() { LDX(); ZPY(); }},         // 0xB6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xB7
        new opcode() { public void opcodeRun() { CLV(); IMP(); }},         // 0xB8
        new opcode() { public void opcodeRun() { LDA(); ABY(); }},         // 0xB9
        new opcode() { public void opcodeRun() { TSX(); IMP(); }},         // 0xBA
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xBB
        new opcode() { public void opcodeRun() { LDY(); ABX(); }},         // 0xBC
        new opcode() { public void opcodeRun() { LDA(); ABX(); }},         // 0xBD
        new opcode() { public void opcodeRun() { LDX(); ABY(); }},         // 0xBE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xBF

        new opcode() { public void opcodeRun() { CPY(); IMM(); }},         // 0xC0
        new opcode() { public void opcodeRun() { CMP(); IZY(); }},         // 0xC1
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xC2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xC3
        new opcode() { public void opcodeRun() { CPY(); ZP0(); }},         // 0xC4
        new opcode() { public void opcodeRun() { CMP(); ZP0(); }},         // 0xC5
        new opcode() { public void opcodeRun() { DEC(); ZP0(); }},         // 0xC6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xC7
        new opcode() { public void opcodeRun() { INY(); IMP(); }},         // 0xC8
        new opcode() { public void opcodeRun() { CMP(); IMM(); }},         // 0xC9
        new opcode() { public void opcodeRun() { DEX(); IMP(); }},         // 0xCA
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xCB
        new opcode() { public void opcodeRun() { CPY(); ABS(); }},         // 0xCC
        new opcode() { public void opcodeRun() { CMP(); ABS(); }},         // 0xCD
        new opcode() { public void opcodeRun() { DEC(); ABS(); }},         // 0xCE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xCF

        new opcode() { public void opcodeRun() { BNE(); REL(); }},         // 0xD0
        new opcode() { public void opcodeRun() { CMP(); IZY(); }},         // 0xD1
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xD2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xD3
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xD4
        new opcode() { public void opcodeRun() { CMP(); ZPX(); }},         // 0xD5
        new opcode() { public void opcodeRun() { DEC(); ZPX(); }},         // 0xD6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xD7
        new opcode() { public void opcodeRun() { CLD(); IMP(); }},         // 0xD8
        new opcode() { public void opcodeRun() { CMP(); ABY(); }},         // 0xD9
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xDA
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xDB
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xDC
        new opcode() { public void opcodeRun() { CMP(); ABX(); }},         // 0xDD
        new opcode() { public void opcodeRun() { DEC(); ABX(); }},         // 0xDE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xDF

        new opcode() { public void opcodeRun() { CPX(); IMM(); }},         // 0xE0
        new opcode() { public void opcodeRun() { SBC(); IZX(); }},         // 0xE1
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xE2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xE3
        new opcode() { public void opcodeRun() { CPX(); ZP0(); }},         // 0xE4
        new opcode() { public void opcodeRun() { SBC(); ZP0(); }},         // 0xE5
        new opcode() { public void opcodeRun() { INC(); ZP0(); }},         // 0xE6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xE7
        new opcode() { public void opcodeRun() { INX(); IMP(); }},         // 0xE8
        new opcode() { public void opcodeRun() { SBC(); IMM(); }},         // 0xE9
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xEA
        new opcode() { public void opcodeRun() { SBC(); IMM(); }},         // 0xEB
        new opcode() { public void opcodeRun() { CPX(); ABS(); }},         // 0xEC
        new opcode() { public void opcodeRun() { SBC(); ABS(); }},         // 0xED
        new opcode() { public void opcodeRun() { INC(); ABS(); }},         // 0xEE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xEF
        
        new opcode() { public void opcodeRun() { BEQ(); REL(); }},         // 0xF0
        new opcode() { public void opcodeRun() { SBC(); IZY(); }},         // 0xF1
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xF2
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xF3
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xF4
        new opcode() { public void opcodeRun() { SBC(); ZPX(); }},         // 0xF5
        new opcode() { public void opcodeRun() { INC(); ZPX(); }},         // 0xF6
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xF7
        new opcode() { public void opcodeRun() { SED(); IMP(); }},         // 0xF8
        new opcode() { public void opcodeRun() { SBC(); ABY(); }},         // 0xF9
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xFA
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xFB
        new opcode() { public void opcodeRun() { NOP(); IMP(); }},         // 0xFC
        new opcode() { public void opcodeRun() { SBC(); ABX(); }},         // 0xFD
        new opcode() { public void opcodeRun() { INC(); ABX(); }},         // 0xFE
        new opcode() { public void opcodeRun() { XXX(); IMP(); }},         // 0xFF
        
    };

    // reset CPU into known state
    private void reset() {
        short resetAddress = (short) 0xFFFC;
        byte temp = fetch(resetAddress);
        pc = 
    }

    // interrupt request
    private void irq() {

    }

    // unmaskable interrupt request
    private void nmi() {

    }

    
//-------------------------------------------------------------------------------------------------
//Addressing Modes
//-------------------------------------------------------------------------------------------------

    // Addressing mode: Implied
    // No extra data needed
    private byte IMP() {
        return 0;
    }

    // Addressing mode: Immediate
    // Instructions target the next byte after the opcode as the data
    private byte IMM() {
        return 0;
    }

    // Addressing mode: Zero Page
    // Instructions are only capable of addressing the 1st page (256 bytes)
    // next byte after opcode as the target address (only requires the lower byte)
    private byte ZP0() {
        return 0;
    }
    
    // Addressing mode: Zero Page + X
    // Zero Page instructions with X added as an offset to the index
    private byte ZPX() {
        return 0;
    }

    // Addressing mode: Zero Page + Y
    // Zero Page instructions with Y added as an offset to the index
    private byte ZPY() {
        return 0;
    }

    // Addressing mode: Relative
    // Next PC is the byte after the opcode + pc
    // Operand is a signed 8 bit integer so can only jump +127, -128
    private byte REL() {
        return 0;
    }

    // Addressing mode: Absolute
    // Full 16 bit addressing mode
    private byte ABS() {
        return 0;
    }

    // Addressing mode: Absolute with X offset
    // Full 16 bit addressing mode with X offset  
    private byte ABX() {
        return 0;
    }

    // Addressing mode: Absolute with Y offset
    // Full 16 bit addressing mode with Y offset  
    private byte ABY() {
        return 0;
    }

    // Addressing mode: Indirect
    // Pointer to 16 address.
    // Hardware bug: If low byte is 0xFF, High byte is not incremented
    private byte IND() {
        return 0;
    }

    // Addressing mode: Indexed indirect with X offset
    // Supplied X register is an offset to page 0
    // 16 bit address read from location X in page 0
    private byte IZX() {
        return 0;
    }

    // Addressing mode: Indirect indexed with Y offset
        // Supplied Y register is an offset the indirect address in page 0
    private byte IZY() {
        return 0;
    }

//-------------------------------------------------------------------------------------------------
//Instructions
//-------------------------------------------------------------------------------------------------

    // Illegal instruction
    private void XXX() {

    }

    // NOP  No Operation
    // ---                              N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       NOP           EA    1     2
    private void NOP() {

    }

    // ADC  Add Memory to Accumulator with Carry
    // A + M + C -> A, C                N Z C I D V
    //                                  + + + - - +
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     ADC #oper     69    2     2
    // zeropage      ADC oper      65    2     3
    // zeropage,X    ADC oper,X    75    2     4
    // absolute      ADC oper      6D    3     4
    // absolute,X    ADC oper,X    7D    3     4*
    // absolute,Y    ADC oper,Y    79    3     4*
    // (indirect,X)  ADC (oper,X)  61    2     6
    // (indirect),Y  ADC (oper),Y  71    2     5*
    private void ADC() {

    }

    // AND  AND Memory with Accumulator
    // A AND M -> A                     N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     AND #oper     29    2     2
    // zeropage      AND oper      25    2     3
    // zeropage,X    AND oper,X    35    2     4
    // absolute      AND oper      2D    3     4
    // absolute,X    AND oper,X    3D    3     4*
    // absolute,Y    AND oper,Y    39    3     4*
    // (indirect,X)  AND (oper,X)  21    2     6
    // (indirect),Y  AND (oper),Y  31    2     5*
    private void AND() {

    }

    // ASL  Shift Left One Bit (Memory or Accumulator)
    // C <- [76543210] <- 0             N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // accumulator   ASL A         0A    1     2
    // zeropage      ASL oper      06    2     5
    // zeropage,X    ASL oper,X    16    2     6
    // absolute      ASL oper      0E    3     6
    // absolute,X    ASL oper,X    1E    3     7
    private void ASL() {

    }

    // BCC  Branch on Carry Clear
    // branch on C = 0                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BCC oper      90    2     2**
    private void BCC() {

    }

    // BCS  Branch on Carry Set
    // branch on C = 1                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BCS oper      B0    2     2**
    private void BCS() {

    }

    // BEQ  Branch on Result Zero
    // branch on Z = 1                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BEQ oper      F0    2     2**
    private void BEQ() {

    }

    // BIT  Test Bits in Memory with Accumulator
    // bits 7 and 6 of operand are transfered to bit 7 and 6 of SR (N,V);
    // the zeroflag is set to the result of operand AND accumulator.
    // A AND M, M7 -> N, M6 -> V        N Z C I D V
    //                                 M7 + - - - M6
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // zeropage      BIT oper      24    2     3
    // absolute      BIT oper      2C    3     4
    private void BIT() {

    }

    // BMI  Branch on Result Minus
    // branch on N = 1                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BMI oper      30    2     2**        
    private void BMI() {

    }

    // BNE  Branch on Result not Zero
    // branch on Z = 0                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BNE oper      D0    2     2**
    private void BNE() {

    }

    // BPL  Branch on Result Plus
    // branch on N = 0                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // relative      BPL oper      10    2     2**
    private void BPL() {

    }

    // BRK  Force Break
    // interrupt,                       N Z C I D V
    // push PC+2, push SR               - - - 1 - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       BRK           00    1     7
    private void BRK() {

    }

    // BVC  Branch on Overflow Clear
    // branch on V = 0                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    private void BVC() {

    }

    // BVC  Branch on Overflow Set
    // branch on V = 1                  N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    private void BVS() {

    }

    // CLC  Clear Carry Flag
    // 0 -> C                           N Z C I D V
    //                                  - - 0 - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       CLC           18    1     2
    private void CLC() {

    }

    // CLD  Clear Decimal Mode
    // 0 -> D                           N Z C I D V
    //                                  - - - - 0 -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       CLD           D8    1     2
    private void CLD() {

    }

    // CLI  Clear Interrupt Disable Bit
    // 0 -> I                           N Z C I D V
    //                                  - - - 0 - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       CLI           58    1     2
    private void CLI() {

    }

    // CLV  Clear Overflow Flag
    // 0 -> V                           N Z C I D V
    //                                  - - - - - 0
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       CLV           B8    1     2
    private void CLV() {

    }

    // CMP  Compare Memory with Accumulator
    // A - M                            N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     CMP #oper     C9    2     2
    // zeropage      CMP oper      C5    2     3
    // zeropage,X    CMP oper,X    D5    2     4
    // absolute      CMP oper      CD    3     4
    // absolute,X    CMP oper,X    DD    3     4*
    // absolute,Y    CMP oper,Y    D9    3     4*
    // (indirect,X)  CMP (oper,X)  C1    2     6
    // (indirect),Y  CMP (oper),Y  D1    2     5*
    private void CMP() {

    }

    // CPX  Compare Memory and Index X
    // X - M                            N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     CPX #oper     E0    2     2
    // zeropage      CPX oper      E4    2     3
    // absolute      CPX oper      EC    3     4
    private void CPX() {

    }

    // CPY  Compare Memory and Index Y
    // Y - M                            N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     CPY #oper     C0    2     2
    // zeropage      CPY oper      C4    2     3
    // absolute      CPY oper      CC    3     4
    private void CPY() {

    }

    // DEC  Decrement Memory by One
    // M - 1 -> M                       N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // zeropage      DEC oper      C6    2     5
    // zeropage,X    DEC oper,X    D6    2     6
    // absolute      DEC oper      CE    3     6
    // absolute,X    DEC oper,X    DE    3     7
    private void DEC() {

    }

    // DEX  Decrement Index X by One
    // X - 1 -> X                       N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       DEC           CA    1     2
    private void DEX() {

    }

    // DEY  Decrement Index Y by One
    // Y - 1 -> Y                       N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       DEC           88    1     2
    private void DEY() {
        
    }

    // EOR  Exclusive-OR Memory with Accumulator
    // A EOR M -> A                     N Z C I D V
    //                                 + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     EOR #oper     49    2     2
    // zeropage      EOR oper      45    2     3
    // zeropage,X    EOR oper,X    55    2     4
    // absolute      EOR oper      4D    3     4
    // absolute,X    EOR oper,X    5D    3     4*
    // absolute,Y    EOR oper,Y    59    3     4*
    // (indirect,X)  EOR (oper,X)  41    2     6
    // (indirect),Y  EOR (oper),Y  51    2     5*
    private void EOR() {

    }

    // INC  Increment Memory by One
    // M + 1 -> M                       N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // zeropage      INC oper      E6    2     5
    // zeropage,X    INC oper,X    F6    2     6
    // absolute      INC oper      EE    3     6
    // absolute,X    INC oper,X    FE    3     7
    private void INC() {

    }

    // INX  Increment Index X by One
    // X + 1 -> X                       N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       INX           E8    1     2
    private void INX() {

    }

    // INY  Increment Index Y by One
    // Y + 1 -> Y                       N Z C I D V
    //                                 + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       INY           C8    1     2
    private void INY() {

    }

    // JMP  Jump to New Location
    // (PC+1) -> PCL                    N Z C I D V
    // (PC+2) -> PCH                    - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // absolute      JMP oper      4C    3     3
    // indirect      JMP (oper)    6C    3     5
    private void JMP() {

    }

    // JSR  Jump to New Location Saving Return Address
    // push (PC+2),                     N Z C I D V
    // (PC+1) -> PCL                    - - - - - -
    // (PC+2) -> PCH
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // absolute      JSR oper      20    3     6
    private void JSR() {

    }

    // LDA  Load Accumulator with Memory
    // M -> A                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     LDA #oper     A9    2     2
    // zeropage      LDA oper      A5    2     3
    // zeropage,X    LDA oper,X    B5    2     4
    // absolute      LDA oper      AD    3     4
    // absolute,X    LDA oper,X    BD    3     4*
    // absolute,Y    LDA oper,Y    B9    3     4*
    // (indirect,X)  LDA (oper,X)  A1    2     6
    // (indirect),Y  LDA (oper),Y  B1    2     5*
    private void LDA() {

    }

    // LDX  Load Index X with Memory
    // M -> X                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     LDX #oper     A2    2     2
    // zeropage      LDX oper      A6    2     3
    // zeropage,Y    LDX oper,Y    B6    2     4
    // absolute      LDX oper      AE    3     4
    // absolute,Y    LDX oper,Y    BE    3     4*
    private void LDX() {

    }

    // LDY  Load Index Y with Memory
    // M -> Y                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     LDY #oper     A0    2     2
    // zeropage      LDY oper      A4    2     3
    // zeropage,X    LDY oper,X    B4    2     4
    // absolute      LDY oper      AC    3     4
    // absolute,X    LDY oper,X    BC    3     4*
    private void LDY() {

    }

    // LSR  Shift One Bit Right (Memory or Accumulator)
    // 0 -> [76543210] -> C             N Z C I D V
    //                                  0 + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // accumulator   LSR A         4A    1     2
    // zeropage      LSR oper      46    2     5
    // zeropage,X    LSR oper,X    56    2     6
    // absolute      LSR oper      4E    3     6
    // absolute,X    LSR oper,X    5E    3     7
    private void LSR() {

    }

    // ORA  OR Memory with Accumulator
    // A OR M -> A                      N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     ORA #oper     09    2     2
    // zeropage      ORA oper      05    2     3
    // zeropage,X    ORA oper,X    15    2     4
    // absolute      ORA oper      0D    3     4
    // absolute,X    ORA oper,X    1D    3     4*
    // absolute,Y    ORA oper,Y    19    3     4*
    // (indirect,X)  ORA (oper,X)  01    2     6
    // (indirect),Y  ORA (oper),Y  11    2     5*
    private void ORA() {

    }

    // PHA  Push Accumulator on Stack
    // push A                           N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       PHA           48    1     3
    private void PHA() {

    }

    // PHP  Push Processor Status on Stack
    // push SR                          N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       PHP           08    1     3
    private void PHP() {

    }

    // PHP  Push Processor Status on Stack
    // push SR                          N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       PHP           08    1     3
    private void PLA() {

    }

    // PHP  Push Processor Status on Stack
    // push SR                          N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       PHP           08    1     3
    private void PLP() {

    }

    // ROL  Rotate One Bit Left (Memory or Accumulator)
    // C <- [76543210] <- C             N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // accumulator   ROL A         2A    1     2
    // zeropage      ROL oper      26    2     5
    // zeropage,X    ROL oper,X    36    2     6
    // absolute      ROL oper      2E    3     6
    // absolute,X    ROL oper,X    3E    3     7
    private void ROL() {

    }

    // ROR  Rotate One Bit Right (Memory or Accumulator)
    // C -> [76543210] -> C             N Z C I D V
    //                                  + + + - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // accumulator   ROR A         6A    1     2
    // zeropage      ROR oper      66    2     5
    // zeropage,X    ROR oper,X    76    2     6
    // absolute      ROR oper      6E    3     6
    // absolute,X    ROR oper,X    7E    3     7
    private void ROR() {

    }

    // RTI  Return from Interrupt
    // pull SR, pull PC                 N Z C I D V
    //                                  from stack
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       RTI           40    1     6
    private void RTI() {

    }

    // RTS  Return from Subroutine
    // pull PC, PC+1 -> PC              N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       RTS           60    1     6
    private void RTS() {

    }

    // SEC  Set Carry Flag
    // 1 -> C                           N Z C I D V
    //                                  - - 1 - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       SEC           38    1     2
    private void SEC() {

    }

    // SBC  Subtract Memory from Accumulator with Borrow
    // A - M - C -> A                   N Z C I D V
    //                                  + + + - - +
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // immidiate     SBC #oper     E9    2     2
    // zeropage      SBC oper      E5    2     3
    // zeropage,X    SBC oper,X    F5    2     4
    // absolute      SBC oper      ED    3     4
    // absolute,X    SBC oper,X    FD    3     4*
    // absolute,Y    SBC oper,Y    F9    3     4*
    // (indirect,X)  SBC (oper,X)  E1    2     6
    // (indirect),Y  SBC (oper),Y  F1    2     5*      
    private void SBC() {

    }

    // SED  Set Decimal Flag
    // 1 -> D                           N Z C I D V
    //                                  - - - - 1 -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       SED           F8    1     2
    private void SED() {

    }

    // SEI  Set Interrupt Disable Status
    // 1 -> I                           N Z C I D V
    //                                  - - - 1 - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       SEI           78    1     2
    private void SEI() {

    }

    // STA  Store Accumulator in Memory
    //  A -> M                           N Z C I D V
    //                                   - - - - - -
    //  addressing    assembler    opc  bytes  cyles
    //  --------------------------------------------
    //  zeropage      STA oper      85    2     3
    //  zeropage,X    STA oper,X    95    2     4
    //  absolute      STA oper      8D    3     4
    //  absolute,X    STA oper,X    9D    3     5
    //  absolute,Y    STA oper,Y    99    3     5
    //  (indirect,X)  STA (oper,X)  81    2     6
    //  (indirect),Y  STA (oper),Y  91    2     6
    private void STA() {

    }

    // STX  Store Index X in Memory
    // X -> M                           N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // zeropage      STX oper      86    2     3
    // zeropage,Y    STX oper,Y    96    2     4
    // absolute      STX oper      8E    3     4
    private void STX() {

    }

    // STY  Sore Index Y in Memory
    // Y -> M                           N Z C I D V
    //                                  - - - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // zeropage      STY oper      84    2     3
    // zeropage,X    STY oper,X    94    2     4
    // absolute      STY oper      8C    3     4
    private void STY() {

    }

    // TAX  Transfer Accumulator to Index X
    // A -> X                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TAX           AA    1     2
    private void TAX() {

    }

    // TAY  Transfer Accumulator to Index Y
    // A -> Y                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TAY           A8    1     2
    private void TAY() {

    }

    // TSX  Transfer Stack Pointer to Index X
    // SP -> X                          N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TSX           BA    1     2
    private void TSX() {

    }

    // TXA  Transfer Index X to Accumulator
    // X -> A                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TXA           8A    1     2
    private void TXA() {

    }

    // TYA  Transfer Index Y to Accumulator
    // Y -> A                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TYA           98    1     2
    private void TXS() {

    }

    // TYA  Transfer Index Y to Accumulator
    // Y -> A                           N Z C I D V
    //                                  + + - - - -
    // addressing    assembler    opc  bytes  cyles
    // --------------------------------------------
    // implied       TYA           98    1     2
    private void TYA() {

    }
}
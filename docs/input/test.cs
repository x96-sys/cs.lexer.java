soi               = 0x2;
eoi               = 0x3;
tab               = 0x9;
nl                = 0xA;
carriage_return   = 0xD;
s                 = 0x20;
hash              = 0x23;
q                 = 0x27;

open_paren        = 0x28;
close_paren       = 0x29;

asterisk          = 0x2A;
plus              = 0x2B;
dash              = 0x2D;
zero              = 0x30;
delimiter         = 0x3B;
assignor          = 0x3D;
question          = 0x3F;
shell             = 0x40;

open_square       = 0x5B;
close_square      = 0x5D;

ghost             = 0x5F;
excluding         = 0x5E;

open_brace        = 0x7B;
p                 = 0x7C;
close_brace       = 0x7D;

any               = [0x20-0x7E];
digit             = [0x30-0x39];

af_up             = [0x41-0x46];
x_up              = 0x58;

af_low            = [0x61-0x66];
x_low             = 0x78;

alpha             = ( alpha_up | alpha_low );
alpha_up          = [0x41-0x5A];
alpha_low         = [0x61-0x7A];
hex_digit         = ( digit | af_low | af_up );

quantifier        = ( asterisk | plus | question );

es                = ( s | tab | carriage_return | nl );

hexadecimal       = zero ( x_up | x_low ) hex_digit+;
range_hex         = hexadecimal dash hexadecimal;
word              = q word_follow+ q;
word_follow       = ^q any;

doc = hash doc_follow*;
doc_follow = ^nl any;

d = (doc | es);  # doc, comment OR empty space

segment          = open_square d* segment_follow+ close_square; # will have `quantifier?`
segment_follow   = axis d*;

choices        = open_paren d* core d* choices_follow+ close_paren; # will have `quantifier?`
choices_follow = [p d* core d*];

unit            =  excluding? glyph quantifier?;

shared          = ( word | unit | choices | segment );
core            = ( shared | hexadecimal );
axis            = ( shared | range_hex );

casing       = open_brace d* core_follow+ close_brace; # will have quantifier
lineage      = core_follow+ delimiter;
core_follow  = [core d*];

modifier        = (ghost | shell) d*;

pattern      = modifier? (lineage | casing);

glyph        = alpha glyph_follow*;
glyph_follow = ( alpha | digit | ghost );

passage        = glyph d* assignor d* pattern;

book         = {soi d* book_follow+ eoi}
book_follow  = passage d*;

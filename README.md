# simple-block
区块链模型初步认知

BlockBO代表区块模型
calculateHash方法采用SHA-256将区块信息加密
mineBlock方法则是生成出的区块hash值必须满足头部difficulty个0

StringUtils是将字符串按照SHA-256进行编码，以十六进制输出结果
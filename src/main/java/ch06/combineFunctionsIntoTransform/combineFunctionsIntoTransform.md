- 입력을 받아서 여러 정보를 도출하는 데, 같은 도출 로직이 반복되는 것을 함수로 묶는다.
- 변환 함수를 사용해서 원본 데이터를 입력받아 정보를 도출한 뒤 각각 데이터 필드에 넣어 반환한다.
```JavaScript
function a()
function b()
    
function c(example) {
    const aExample = _.cloneDeep(example);
    aExample.e1 = a(example)
    aExample.e2 = b(example)
    return aExample;
}
```
- 클래스로 묶는 것과 차이는, 원본 데이터가 코드 안에서 갱신될 때는 클래스로 묶는 편이 낫다. 
  변환 함수로 묶으면 가공한 데이터를 새로운 레코드에 저장하므로, 원본 데이터가 수정되면 일관성이 깨질 수 있다.
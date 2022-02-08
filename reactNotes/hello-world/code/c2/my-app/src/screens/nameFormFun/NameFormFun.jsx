import React, { useState } from 'react'

export default function NameFormFun() {

    const [name, setName] = useState(''); // name
    const [textareaVal, setTextareaVal] = useState(''); // textarea
    const [selectVal, setSelectVal] = useState(['coconut']); // textarea

    function handleChangeInput(event) {
        setName(event.target.value);
    };
    function handleChangeTextarea(event) {
        setTextareaVal(event.target.value);
    };
    function handleChangeSelect(event) {
        setSelectVal(event.target.value);
    };

    function handleSubmit(event) {
        alert('提交的：输入框=' + name + ',文本域=' + textareaVal+ ',下拉框=' + selectVal);
        event.preventDefalut();
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>
                    输入框：
                    <input type="text" value={name} onChange={handleChangeInput} />
                </label>
            </div>
            <div>
                <label>
                    文本域：
                    <textarea value={textareaVal} onChange={handleChangeTextarea} />
                </label>
            </div>
            <div>
                <label>
                    下拉框：
                    <select value={selectVal}  onChange={handleChangeSelect}>
                        <option value="grapefruit">葡萄柚</option>
                        <option value="lime">酸橙</option>
                        <option value="coconut">椰子</option>
                        <option value="mango">芒果</option>
                    </select>
                </label>
            </div>
            <div>
                <input type="submit" value="提交" />
            </div>
        </form>
    )
}

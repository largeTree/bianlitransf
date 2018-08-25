function Pages(params, changeEvent) {

    params.ratio = params.ratio || 0.25;
    params.initIdx = params.initIdx || 0;

    // 分页插件实体
    var $this = {};

    var $pages = $(params.selector);

    // 避免内部元素溢出显示
    $pages.css('position', 'relative');

    var width = $(params.selector).width();

    $this.$pages = $pages;

    var $itemContainer = $pages.children('.item-container');
    $itemContainer.children('.page-item').width(width);
    var $items = $itemContainer.children('.page-item');

    $this.$items = $items;
    var itemCount = $items.length;
    $this.itemCount = itemCount;

    $this.onchange = changeEvent;

    $itemContainer.width(width * itemCount);

    var maxIdx = itemCount - 1;
    var curIdx = params.initIdx;
    var curLeft = 0;
    var startX;
    $items.on('touchstart', function(event) {
        startX = event.originalEvent.changedTouches[0].pageX;
        // console.log('startX' + startX);
    });

    $items.on('touchmove', function(event) {
        var movedX = event.originalEvent.targetTouches[0].pageX;
        // console.log('movedX = ' + movedX);
        var x = movedX - startX;
        // console.log('x = ' + x);
        x = curLeft + x;
        // console.log('left = ' + x);
        $itemContainer.css('left', x);
    });

    $items.on('touchend', function(event) {
        var moveEndX = event.originalEvent.changedTouches[0].pageX;
        var x = moveEndX - startX;
        // console.log('moveEndX = ' + moveEndX);
        // console.log('x = ' + x);
        var ratio = (Math.abs(x) / width);
        // console.log('百分比：' + ratio);
        var nextIdx = 0;
        if (ratio > 0.25) {
            if (x < 0) {
                // 下一个
                nextIdx = curIdx + 1;
            } else {
                // 上一个
                nextIdx = curIdx - 1;
            }
        } else {
            nextIdx = curIdx;
        }
        moveTo(nextIdx);
    });

    // 构造成功即触发一次变更事件
    try {
        $this.onchange.call($this, curIdx, curIdx, $items[curIdx]);
    } catch (e) {
        console.error(e);
    }

    function moveTo(idx) {
        if (idx > maxIdx) {
            idx = maxIdx;
        }
        if (idx < 0) {
            idx = 0;
        }
        curLeft = -(idx * width);
        // setDisplay(idx);
        $itemContainer.animate({
            left: curLeft
        }, 200, function() {
            if (idx != curIdx) {
                // 页面发生变化，触发变化事件
                try {
                    $this.onchange.call($this, idx, curIdx, $items[idx]);
                } catch (e) {
                    console.error(e);
                }
            }
            curIdx = idx;
        });
    }
    // setDisplay(curIdx);

    // function setDisplay(idx) {
    //     for (var i = 0; i < $items.length; i++) {
    //         if (idx == i) {
    //             $($items[i]).show();
    //         } else {
    //             $($items[i]).hide();
    //         }
    //     }
    // }

    return $this;
}